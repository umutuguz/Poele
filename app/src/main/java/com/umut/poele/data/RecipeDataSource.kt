package com.umut.poele.data

import com.umut.poele.R
import com.umut.poele.model.Recipe

class RecipeDataSource {

    fun loadRecipe(): List<Recipe> {
        return listOf<Recipe>(
            Recipe(1, "Lasagne", "Umut", "Pasta", 10, 4, 600, R.drawable.coffee_beans),
            Recipe(1, "Lasagne", "Umut", "Rice", 10, 4, 600, R.drawable.coffee_beans),
            Recipe(1, "Lasagne", "Umut", "Meat", 10, 4, 600, R.drawable.coffee_beans),
            Recipe(1, "Lasagne", "Umut", "Chicken", 10, 4, 600, R.drawable.coffee_beans),
            Recipe(1, "Lasagne", "Umut", "Fish", 10, 4, 600, R.drawable.coffee_beans),
            Recipe(1, "Lasagne", "Umut", "Dessert", 10, 4, 600, R.drawable.coffee_beans),
            Recipe(1, "Lasagne", "Umut", "Vegetable", 10, 4, 600, R.drawable.coffee_beans),
        )
    }
}
