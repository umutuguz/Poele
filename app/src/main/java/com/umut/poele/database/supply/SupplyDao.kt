package com.umut.poele.database.supply

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.umut.poele.database.relation.SupplyCategoryCrossRef
import kotlinx.coroutines.flow.Flow

@Dao
interface SupplyDao {

//    @Transaction
//    @Query("SELECT * FROM user WHERE user_id = :userId")
//    fun getAllSuppliesWithUserId(userId: Int): Flow<List<SupplyWithUsers>>

//    @Transaction
//    @Query("SELECT * FROM supply WHERE supply_id = :supplyId")
//    fun getCategoriesWithSupplyId(supplyId: Int): Flow<List<SupplyCategoryWithSupplies>>

//    @Transaction
//    @Query("SELECT * FROM macro WHERE supply_id = :supplyId")
//    fun getMacroWithSupplyId(supplyId: Int): Flow<List<Macro>>
//
//    @Transaction
//    @Query("SELECT * FROM amount WHERE supply_id = :supplyId ORDER BY amount_id ASC")
//    fun getAmountWithSupplyId(supplyId: Int): Flow<List<Amount>>

    @Query("SELECT * FROM supply ORDER BY title ASC")
    fun getAll(): Flow<List<Supply>>

    @Upsert
    suspend fun upsertSupply(supply: Supply)
    @Upsert
    suspend fun upsertSupplyCategoryCrossRef(crossRef: SupplyCategoryCrossRef)
}
