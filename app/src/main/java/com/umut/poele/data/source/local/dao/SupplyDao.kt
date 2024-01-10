package com.umut.poele.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.umut.poele.data.source.local.entity.AmountEntity
import com.umut.poele.data.source.local.entity.MacroEntity
import com.umut.poele.data.source.local.entity.ShopListEntity
import com.umut.poele.data.source.local.entity.ShopListSupplyEntity
import com.umut.poele.data.source.local.entity.SupplyCategoryEntity
import com.umut.poele.data.source.local.entity.SupplyEntity
import com.umut.poele.data.source.local.relation.SupplyCategoryCrossRef
import com.umut.poele.data.source.local.relation.SupplyWithAmounts
import com.umut.poele.data.source.local.relation.UserWithRecipes
import com.umut.poele.data.source.local.relation.UserWithSupplies
import kotlinx.coroutines.flow.Flow

@Dao
interface SupplyDao {

    @Query("SELECT * FROM supply ORDER BY title ASC")
    fun getAll(): List<SupplyEntity>

    @Transaction
    @Query("SELECT * FROM supply WHERE supply_id = :supplyId")
    fun getAmountWithSupply(supplyId: Int): SupplyWithAmounts

    @Transaction
    @Query("SELECT * FROM user WHERE user_id = :userId")
    fun getSuppliesWithUserId(userId: Int): UserWithSupplies

    @Query("DELETE FROM amount WHERE amount_id = :amountId")
    suspend fun deleteSupplyFromFridge(amountId: Int): Int

    @Query("SELECT * FROM shoplist_supply ORDER BY supply_title ASC")
    fun getSupplyShopList(): List<ShopListSupplyEntity>

    @Query("DELETE FROM shoplist_supply")
    suspend fun deleteAllSuppliesFromShopList(): Int

    @Delete
    suspend fun deleteSupplyFromShopList(shopListSupplyEntity: ShopListSupplyEntity)

    @Upsert
    suspend fun upsertSupplyToShopList(shopListSupplyEntity: ShopListSupplyEntity)

    @Upsert
    suspend fun upsertSupply(supply: SupplyEntity)

    @Upsert
    suspend fun upsertSupplyCategoryCrossRef(crossRef: SupplyCategoryCrossRef)

    @Upsert
    suspend fun upsertAmount(amount: AmountEntity)

    @Upsert
    suspend fun upsertSupplyCategory(supplyCategory: SupplyCategoryEntity)

    @Upsert
    suspend fun upsertMacro(macro: MacroEntity)
}
