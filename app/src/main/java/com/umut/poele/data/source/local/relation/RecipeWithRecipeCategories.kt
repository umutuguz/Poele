package com.umut.poele.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.data.source.local.entity.RecipeCategoryEntity
import com.umut.poele.data.source.local.entity.RecipeEntity

data class RecipeWithRecipeCategories(
    @Embedded val recipe: RecipeEntity,
    @Relation(
        parentColumn = "recipe_id",
        entityColumn = "recipe_category_title",
        associateBy = Junction(RecipeCategoryCrossRef::class)
    )
    val categories: List<RecipeCategoryEntity>
)
