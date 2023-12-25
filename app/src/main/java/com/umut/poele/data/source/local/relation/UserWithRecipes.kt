package com.umut.poele.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.data.source.local.entity.RecipeEntity
import com.umut.poele.data.source.local.entity.UserEntity

data class UserWithRecipes(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "recipe_id",
        associateBy = Junction(UserRecipeCrossRef::class)
    )
    val recipes: List<RecipeEntity>
)
