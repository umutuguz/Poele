package com.umut.poele.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.data.source.local.entity.RecipeCategoryEntity
import com.umut.poele.data.source.local.entity.RecipeEntity

data class RecipeCategoryWithRecipes(
    @Embedded val recipeCategory: RecipeCategoryEntity,
    @Relation(
        parentColumn = "recipe_category_title",
        entityColumn = "recipe_id",
        associateBy = Junction(RecipeCategoryCrossRef::class)
    )
    val recipes: List<RecipeEntity>
)
