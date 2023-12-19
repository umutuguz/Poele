package com.umut.poele.database.category

import androidx.room.Dao
import androidx.room.Upsert

@Dao
interface SupplyCategoryDao {

    @Upsert
    suspend fun upsertSupplyCategory(supplyCategory: SupplyCategory)
}
