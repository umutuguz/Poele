package com.umut.poele.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.data.source.local.entity.RecipeEntity
import com.umut.poele.data.source.local.entity.UserEntity

data class RecipeWithUsers(
    @Embedded val recipe: RecipeEntity,
    @Relation(
        parentColumn = "recipe_id",
        entityColumn = "user_id",
        associateBy = Junction(UserRecipeCrossRef::class)
    )
    val users: List<UserEntity>
)
