package com.umut.poele.domain.use_case

import android.util.Log
import com.umut.poele.data.source.local.entity.ShopListSupplyEntity
import com.umut.poele.data.source.local.entity.toSupply
import com.umut.poele.domain.model.Supply
import com.umut.poele.domain.model.toLocalDate
import com.umut.poele.domain.model.toState
import com.umut.poele.domain.model.toUnit
import com.umut.poele.domain.repository.SupplyRepository
import com.umut.poele.ui.choose.SelectedUser
import com.umut.poele.util.Resource
import kotlinx.coroutines.Dispatchers
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
                    supplies.add(it.toSupply(userId))
                }
            } catch (e: IOException) {
                Log.e("IOException", e.localizedMessage ?: "IO Error occured")
            }
        }
        return Resource.Success(supplies)
    }

    suspend fun getAmountWithSupplyId(supplyId: Int): Resource<Supply> {
        var supply = Supply()
        withContext(Dispatchers.IO) {
            try {
                supplyRepository.getAmountWithSupplyId(supplyId).amounts.forEach {
                    supply = if (it.supplyId == supplyId && it.userId == SelectedUser.userId) {
                        Supply(
                            supplyId,
                            amount = it.amount,
                            unit = it.unit.lowercase().toUnit(),
                            date = it.date.toLocalDate(),
                            state = it.state.toState(),
                            amountId = it.amountId,
                            userId = it.userId
                        )

                    }
                    else {
                        Supply()
                    }
                }
            } catch (e: IOException) {
                Log.e("IOException", e.localizedMessage ?: "IO Error occured")
            }
        }
        if (supply.id == -1) {
            supply = Supply()
        }
        return Resource.Success(supply)
    }

    suspend fun getShopListSupply(): Resource<List<Supply>> {
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
        var result: Boolean
        withContext(Dispatchers.IO) {
            result = supplyRepository.deleteAllSuppliesFromShopList()
        }
        return result
    }

    suspend fun deleteSupplyFromFridge(amountId: Int, userId: Int): Resource<List<Supply>> {
        val supplyResult = mutableListOf<Supply>()
        val supplyWithAmountList = mutableListOf<Supply>()
        withContext(Dispatchers.IO) {
            try {
                val deleteResponse = supplyRepository.deleteSupplyFromFridge(amountId)
                if (deleteResponse) {
                    supplyResult.addAll(supplyRepository.getSuppliesWithUserId(userId).supplies.map { it.toSupply(userId) })

                    supplyResult.forEach { supply ->
                        getAmountWithSupplyId(supply.id).data?.let { amountSupply ->
                            if (amountSupply.userId == SelectedUser.userId) {
                                supply.amount = amountSupply.amount
                                supply.date = amountSupply.date
                                supply.unit = amountSupply.unit
                                supply.state = amountSupply.state
                                supply.amountId = amountSupply.amountId
                                supplyWithAmountList.add(supply)
                            }
                        }
                    }
                }
                else Unit

            } catch (e: IOException) {
                Log.e("IOException", e.localizedMessage ?: "IO Error occured")
            }
        }
        return Resource.Success(supplyWithAmountList)
    }
}
