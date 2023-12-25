package com.umut.poele.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.data.source.local.entity.SupplyCategoryEntity
import com.umut.poele.data.source.local.entity.SupplyEntity

data class SupplyWithSupplyCategories(
    @Embedded val supply: SupplyEntity,
    @Relation(
        parentColumn = "supply_id",
        entityColumn = "supply_category_title",
        associateBy = Junction(SupplyCategoryCrossRef::class)
    )
    val categories: List<SupplyCategoryEntity>
)
