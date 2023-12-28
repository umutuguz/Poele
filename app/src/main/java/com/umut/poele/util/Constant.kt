package com.umut.poele.util

import androidx.room.Database

object Constant {

    const val KEY_DISMISS = "KEY_DISMISS"
    val RECIPE_DETAIL_TAB_NAME = listOf("Info", "Ingredient", "DirectionEntity")
    val SEARCH_TAB_NAME = listOf("RecipeModel", "Ingredient")
    val ENTER_DAILY_MENU_TAB_NAME = listOf("Breakfast", "Brunch", "Lunch", "Dinner")
    const val BASE_URL = "https://www.themealdb.com/api/json/v1/1"
    const val LOCALHOST = "127.0.0.1"
    const val AUTH_PORT = 9099
    const val EMULATOR_PORT = 4000
    const val FUNCTION_PORT = 5001
    const val DATABASE_PORT = 9000
    const val FIRESTORE_PORT = 8080
    const val STORAGE_PORT = 9199

}

enum class Units { ML, GRAM, TEASPOON, TABLESPOON, DESSERTSPOON, CUP, PINCH, PIECE
}

enum class States { UNUSED, USED
}

enum class Levels { EASY, INTERMEDIATE, HARD
}

enum class Meals { BREAKFAST, BRUNCH, LUNCH, DINNER }
