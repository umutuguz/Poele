package com.umut.poele.database.address

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface AddressDao {

    @Query("SELECT * FROM address ORDER BY title ASC")
    fun getAll(): List<Address>

    @Upsert
    suspend fun upsertAddress(address: Address)
}
