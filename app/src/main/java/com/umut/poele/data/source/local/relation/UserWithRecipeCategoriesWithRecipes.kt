package com.umut.poele.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.umut.poele.data.source.local.entity.RecipeEntity
import com.umut.poele.data.source.local.entity.UserEntity

data class UserWithRecipeCategoriesWithRecipes (
    @Embedded val user: UserEntity,
    @Relation(
        entity = RecipeEntity::class,
        parentColumn = "user_id",
        entityColumn = "recipe_id"
    )
    val recipes: List<RecipeWithRecipeCategories>
)
