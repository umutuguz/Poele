package com.umut.poele.util

object Constants {

    const val KEY_DISMISS = "KEY_DISMISS"
    val RECIPE_DETAIL_TAB_NAME = listOf<String>("Info", "Ingredient", "DirectionEntity")
    val SEARCH_TAB_NAME = listOf<String>("RecipeModel", "Ingredient")
    val ENTER_DAILY_MENU_TAB_NAME = listOf<String>("Breakfast", "Brunch", "Lunch", "Dinner")
    const val BASE_URL = "https://www.themealdb.com/api/json/v1/1"
}

enum class Units { ML, GRAM, TEASPOON, TABLESPOON, DESSERTSPOON, CUP, PINCH, PIECE
}

enum class States { UNUSED, USED
}

enum class Levels { EASY, INTERMEDIATE, HARD
}

enum class Meals { BREAKFAST, BRUNCH, LUNCH, DINNER}
