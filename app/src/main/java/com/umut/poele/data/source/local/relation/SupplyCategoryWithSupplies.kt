package com.umut.poele.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.data.source.local.entity.SupplyCategoryEntity
import com.umut.poele.data.source.local.entity.SupplyEntity

class SupplyCategoryWithSupplies(
    @Embedded val category: SupplyCategoryEntity,
    @Relation(
        parentColumn = "supply_category_title",
        entityColumn = "supply_id",
        associateBy = Junction(SupplyCategoryCrossRef::class)
    )
    val supplies: List<SupplyEntity>
)
