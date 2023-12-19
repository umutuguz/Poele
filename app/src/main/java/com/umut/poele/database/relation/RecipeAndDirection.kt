package com.umut.poele.database.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.umut.poele.database.direction.Direction
import com.umut.poele.database.recipe.Recipe

data class RecipeAndDirection(
    @Embedded val recipe: Recipe,
    @Relation(
        parentColumn = "recipe_id",
        entityColumn = "direction_id"
        )
    val direction: Direction
)
