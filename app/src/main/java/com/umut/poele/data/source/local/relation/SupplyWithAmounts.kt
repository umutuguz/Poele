package com.umut.poele.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.umut.poele.data.source.local.entity.AmountEntity
import com.umut.poele.data.source.local.entity.SupplyEntity

data class SupplyWithAmounts(
    @Embedded val supply: SupplyEntity,
    @Relation(
        parentColumn = "supply_id",
        entityColumn = "amount_id"
    )
    val amounts: List<AmountEntity>
)
