package com.umut.poele.database.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.database.category.RecipeCategory
import com.umut.poele.database.recipe.Recipe

data class RecipeCategoryWithRecipes(
    @Embedded val recipeCategory: RecipeCategory,
    @Relation(
        parentColumn = "recipe_category_title",
        entityColumn = "recipe_id",
        associateBy = Junction(RecipeCategoryCrossRef::class)
    )
    val recipes: List<Recipe>
)
