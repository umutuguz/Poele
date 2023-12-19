package com.umut.poele.database.amount

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.umut.poele.database.supply.Supply
import kotlinx.coroutines.flow.Flow

@Dao
interface AmountDao {

    @Upsert
    suspend fun upsertAmount(amount: Amount)
}
