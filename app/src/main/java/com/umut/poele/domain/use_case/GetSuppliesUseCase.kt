package com.umut.poele.domain.use_case

import android.util.Log
import com.umut.poele.data.source.local.entity.toSupply
import com.umut.poele.domain.model.Supply
import com.umut.poele.domain.model.toLocalDate
import com.umut.poele.domain.model.toState
import com.umut.poele.domain.model.toUnit
import com.umut.poele.domain.repository.RecipeRepository
import com.umut.poele.domain.repository.SupplyRepository
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
        Log.i("umutcan", "usecase supply list: ${supplies}")
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
}
