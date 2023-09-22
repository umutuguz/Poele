package com.umut.poele.data

import com.umut.poele.model.Recipe
import com.umut.poele.model.RecipeTab

class RecipeTabDataSource {
    fun loadRecipeTab(): List<RecipeTab>{
        return listOf<RecipeTab>(
            RecipeTab("Pasta"),
            RecipeTab("Fish"),
            RecipeTab("Meat"),
            RecipeTab("Chicken"),
            RecipeTab("Rice")
        )
    }
}
