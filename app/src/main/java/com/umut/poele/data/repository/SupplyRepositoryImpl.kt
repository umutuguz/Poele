package com.umut.poele.data.repository

import com.umut.poele.data.source.local.dao.SupplyDao
import com.umut.poele.data.source.local.entity.SupplyEntity
import com.umut.poele.data.source.local.relation.SupplyWithAmounts
import com.umut.poele.data.source.local.relation.UserWithSupplies
import com.umut.poele.domain.model.Supply
import com.umut.poele.domain.repository.SupplyRepository
import com.umut.poele.ui.choose.SelectedUser.userId
import com.umut.poele.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList

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
}
