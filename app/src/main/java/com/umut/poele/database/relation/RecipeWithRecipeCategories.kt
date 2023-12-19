package com.umut.poele.database.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.database.category.RecipeCategory
import com.umut.poele.database.recipe.Recipe

data class RecipeWithRecipeCategories(
    @Embedded val recipe: Recipe,
    @Relation(
        parentColumn = "recipe_id",
        entityColumn = "recipe_category_title",
        associateBy = Junction(RecipeCategoryCrossRef::class)
    )
    val categories: List<RecipeCategory>
)
