package com.umut.poele.database.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.database.cuisine.Cuisine
import com.umut.poele.database.recipe.Recipe

class CuisineWithRecipes(
    @Embedded val cuisine: Cuisine,
    @Relation(
        parentColumn = "cuisine_title",
        entityColumn = "recipe_id",
        associateBy = Junction(RecipeCuisineCrossRef::class)
    )
    val recipes: List<Recipe>
)
