package com.umut.poele.database.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.database.recipe.Recipe
import com.umut.poele.database.supply.Supply

data class RecipeWithSupplies(
    @Embedded val recipe: Recipe,
    @Relation(
        parentColumn = "recipe_id",
        entityColumn = "supply_id",
        associateBy = Junction(RecipeSupplyCrossRef::class)
    )
    val supplies: List<Supply>
)
