package com.umut.poele.data.repository

import com.umut.poele.data.source.local.dao.SupplyDao
import com.umut.poele.data.source.local.entity.ShopListSupplyEntity
import com.umut.poele.data.source.local.entity.SupplyEntity
import com.umut.poele.data.source.local.relation.SupplyWithAmounts
import com.umut.poele.data.source.local.relation.UserWithSupplies
import com.umut.poele.domain.repository.SupplyRepository

class SupplyRepositoryImpl(private val supplyDao: SupplyDao) : SupplyRepository {

    override fun getSupplies(): List<SupplyEntity> {
        return supplyDao.getAll()
    }

    override fun getSuppliesWithUserId(userId: Int): UserWithSupplies {
        return supplyDao.getSuppliesWithUserId(userId)
    }

    override fun getAmountWithSupplyId(supplyId: Int): SupplyWithAmounts {
        return supplyDao.getAmountWithSupply(supplyId)
    }

    override suspend fun getShopListSupply(): List<ShopListSupplyEntity> {
        val result = supplyDao.getSupplyShopList()
        return if (result.isNotEmpty()) {
            result
        }
        else {
            emptyList()
        }
    }

    override suspend fun upsertShopListSupply(shopListSupplyEntity: ShopListSupplyEntity) {
        if (shopListSupplyEntity.supplyTitle.isNotEmpty()) {
            supplyDao.upsertSupplyToShopList(shopListSupplyEntity)
        }
    }

    override suspend fun deleteAllSuppliesFromShopList(): Boolean {
        val result = supplyDao.deleteAllSuppliesFromShopList()
        return result > 0
    }
}
