package com.umut.poele.data

import com.umut.poele.model.Recipe

class RecipeDataSource {

    fun loadRecipe(): List<Recipe> {
        return listOf<Recipe>(
            Recipe(1, "Lasagne", "Umut", "Pasta", 10, 4, 600),
            Recipe(1, "Lasagne", "Umut", "Pasta", 10, 4, 600),
            Recipe(1, "Lasagne", "Umut", "Pasta", 10, 4, 600),
            Recipe(1, "Lasagne", "Umut", "Pasta", 10, 4, 600),
            Recipe(1, "Lasagne", "Umut", "Pasta", 10, 4, 600),
            Recipe(1, "Lasagne", "Umut", "Pasta", 10, 4, 600),
            Recipe(1, "Lasagne", "Umut", "Pasta", 10, 4, 600)
        )
    }
}
