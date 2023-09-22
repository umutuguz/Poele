package com.umut.poele.util

import com.umut.poele.model.FoodCategory
import com.umut.poele.model.Recipe
import com.umut.poele.model.RecipeDetail

interface FoodCategoryListener {
    fun onFoodCategoryClicked(clickedFoodCategory: FoodCategory)
}

interface RecipeListener {
    fun onRecipeClicked(clickedRecipe: Recipe)
}

interface RecipeDetailListener {
    fun onRecipeDetailClicked(clickedRecipeDetail: RecipeDetail)
}
