package com.umut.poele.database.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.database.recipe.Recipe
import com.umut.poele.database.user.User

data class RecipeWithUsers(
    @Embedded val recipe: Recipe,
    @Relation(
        parentColumn = "recipe_id",
        entityColumn = "user_id",
        associateBy = Junction(UserRecipeCrossRef::class)
    )
    val users: List<User>
)
