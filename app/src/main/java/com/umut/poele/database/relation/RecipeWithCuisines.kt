package com.umut.poele.database.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.database.cuisine.Cuisine
import com.umut.poele.database.recipe.Recipe

data class RecipeWithCuisines(
    @Embedded val recipe: Recipe,
    @Relation(
        parentColumn = "recipe_id",
        entityColumn = "cuisine_title",
        associateBy = Junction(RecipeCuisineCrossRef::class)
    )
    val cuisines: List<Cuisine>
)
