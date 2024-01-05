package com.umut.poele.domain.use_case

import android.util.Log
import com.umut.poele.data.source.local.entity.ShopListEntity
import com.umut.poele.data.source.local.entity.ShopListSupplyEntity
import com.umut.poele.data.source.local.entity.toRecipeBasic
import com.umut.poele.data.source.local.entity.toSupply
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.domain.model.Supply
import com.umut.poele.domain.model.toLocalDate
import com.umut.poele.domain.model.toState
import com.umut.poele.domain.model.toUnit
import com.umut.poele.domain.repository.RecipeRepository
import com.umut.poele.domain.repository.SupplyRepository
import com.umut.poele.ui.fridge.SupplyListAdapter
import com.umut.poele.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class GetSuppliesUseCase @Inject constructor(private val supplyRepository: SupplyRepository) {

    suspend fun getSupplies(): Resource<List<Supply>> {
        val supplies = mutableListOf<Supply>()
        withContext(Dispatchers.IO) {
            try {
                supplyRepository.getSupplies().forEach {
                    supplies.add(it.toSupply())
                }

            } catch (e: IOException) {
                Log.e("IOException", e.localizedMessage ?: "IO Error occured")
            }
        }
        return Resource.Success(supplies)
    }

    suspend fun getSuppliesWithUserId(userId: Int): Resource<List<Supply>> {
        val supplies = mutableListOf<Supply>()
        withContext(Dispatchers.IO) {
            try {
                supplyRepository.getSuppliesWithUserId(userId).supplies.forEach {
                    supplies.add(it.toSupply())
                }
            } catch (e: IOException) {
                Log.e("IOException", e.localizedMessage ?: "IO Error occured")
            }
        }
        return Resource.Success(supplies)
    }

    suspend fun getAmountWithSupplyId(supplyId: Int): Resource<Supply> {
        val supply = mutableListOf<Supply>()
        withContext(Dispatchers.IO) {
            try {
                supplyRepository.getAmountWithSupplyId(supplyId).amounts.forEach {
                    if (it.supplyId == supplyId) {
                        supply.add(
                            Supply(
                                supplyId,
                                amount = it.amount,
                                unit = it.unit.lowercase().toUnit(),
                                date = it.date.toLocalDate(),
                                state = it.state.toState()
                            )
                        )
                    }
                    else {
                        supply.add(Supply())
                    }
                }
            } catch (e: IOException) {
                Log.e("IOException", e.localizedMessage ?: "IO Error occured")
            }
        }
        if (supply.isEmpty()) {
            supply.add(Supply())
        }
        return Resource.Success(supply.first())
    }

    suspend fun getShopListSupply() : Resource<List<Supply>> {
        var shopList = emptyList<Supply>()
        withContext(Dispatchers.IO) {
            try {
                shopList = supplyRepository.getShopListSupply().map { it.toSupply() }
            } catch (e: IOException) {
                Log.e("IOException", e.localizedMessage ?: "IO Error occured")
            }
        }
        return Resource.Success(shopList)
    }

    suspend fun upsertSupplyToShopListSupply(supply: Supply) {
        val shopListItem = ShopListSupplyEntity(
            supply.id,
            supply.title,
            supply.imageUrl,
            supply.amount,
            supply.unit.toString().lowercase(),
            )
        withContext(Dispatchers.IO) {
            supplyRepository.upsertShopListSupply(shopListItem)
        }
    }

    suspend fun deleteShopList(): Boolean {
        var result = false
        withContext(Dispatchers.IO) {
            result = supplyRepository.deleteAllSuppliesFromShopList()
        }
        return result
    }

}
