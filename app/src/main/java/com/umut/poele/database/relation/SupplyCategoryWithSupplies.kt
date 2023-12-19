package com.umut.poele.database.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.database.category.SupplyCategory
import com.umut.poele.database.supply.Supply

class SupplyCategoryWithSupplies(
    @Embedded val category: SupplyCategory,
    @Relation(
        parentColumn = "supply_category_title",
        entityColumn = "supply_id",
        associateBy = Junction(SupplyCategoryCrossRef::class)
    )
    val supplies: List<Supply>
)
