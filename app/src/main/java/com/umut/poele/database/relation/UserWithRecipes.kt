package com.umut.poele.database.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.database.recipe.Recipe
import com.umut.poele.database.user.User

data class UserWithRecipes(
    @Embedded val user: User,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "recipe_id",
        associateBy = Junction(UserRecipeCrossRef::class)
    )
    val recipes: List<Recipe>
)
