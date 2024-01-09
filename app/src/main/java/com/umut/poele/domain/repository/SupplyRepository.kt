package com.umut.poele.domain.repository

import com.umut.poele.data.source.local.entity.ShopListEntity
import com.umut.poele.data.source.local.entity.ShopListSupplyEntity
import com.umut.poele.data.source.local.entity.SupplyEntity
import com.umut.poele.data.source.local.relation.SupplyWithAmounts
import com.umut.poele.data.source.local.relation.UserWithSupplies


interface SupplyRepository {

    fun getSupplies(): List<SupplyEntity>

    fun getSuppliesWithUserId(userId: Int) : UserWithSupplies

    fun getAmountWithSupplyId(supplyId: Int) : SupplyWithAmounts

    suspend fun getShopListSupply() : List<ShopListSupplyEntity>

    suspend fun upsertShopListSupply(shopListSupplyEntity: ShopListSupplyEntity)

    suspend fun deleteAllSuppliesFromShopList(): Boolean

    suspend fun deleteSupplyFromFridge(amountId: Int) : Boolean
}
