package com.umut.poele.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.data.source.local.entity.RecipeEntity
import com.umut.poele.data.source.local.entity.SupplyEntity

data class RecipeWithSupplies(
    @Embedded val recipe: RecipeEntity,
    @Relation(
        parentColumn = "recipe_id",
        entityColumn = "supply_id",
        associateBy = Junction(RecipeSupplyCrossRef::class)
    )
    val supplies: List<SupplyEntity>
)
