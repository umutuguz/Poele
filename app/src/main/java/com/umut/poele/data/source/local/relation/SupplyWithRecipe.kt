package com.umut.poele.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.data.source.local.entity.RecipeEntity
import com.umut.poele.data.source.local.entity.SupplyEntity

data class SupplyWithRecipe(
    @Embedded val supply: SupplyEntity,
    @Relation(
        parentColumn = "supply_id",
        entityColumn = "recipe_id",
        associateBy = Junction(RecipeSupplyCrossRef::class)
    )
    val recipes: List<RecipeEntity>
)
