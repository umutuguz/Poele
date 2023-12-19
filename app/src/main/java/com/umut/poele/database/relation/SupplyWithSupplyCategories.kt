package com.umut.poele.database.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.database.category.SupplyCategory
import com.umut.poele.database.supply.Supply

data class SupplyWithSupplyCategories(
    @Embedded val supply: Supply,
    @Relation(
        parentColumn = "supply_id",
        entityColumn = "supply_category_title",
        associateBy = Junction(SupplyCategoryCrossRef::class)
    )
    val categories: List<SupplyCategory>
)
