package com.umut.poele.util

import androidx.room.Database
import com.umut.poele.domain.model.MealCategory

object Constant {

    const val KEY_DISMISS = "KEY_DISMISS"
    val RECIPE_DETAIL_TAB_NAME = listOf("Info", "Ingredient", "Direction")
    val SEARCH_TAB_NAME = listOf("Recipe", "Ingredient")
    val ENTER_DAILY_MENU_TAB_NAME = listOf("Breakfast", "Brunch", "Lunch", "Dinner")
    const val BASE_URL = "https://api.spoonacular.com"
    const val LOCALHOST = "127.0.0.1"
    const val AUTH_PORT = 9099
    const val EMULATOR_PORT = 4000
    const val DATABASE_PORT = 9000
    const val FIRESTORE_PORT = 8080

}

enum class Units { ML, GRAM, TEASPOON, TABLESPOON, DESSERTSPOON, CUP, PINCH, PIECE, CLOVES, SERVINGS, UNDETERMINED
}

enum class States { UNUSED, USED, UNDETERMINED
}

enum class Levels { EASY, INTERMEDIATE, HARD, UNDETERMINED
}

enum class Meals { BREAKFAST, BRUNCH, LUNCH, DINNER, UNDETERMINED }

enum class MealTypes {MAINCOURSE, SIDEDISH, DESSERT, APPETIZER}
//, SALAD, BREAD, BREAKFAST, SOUP, BEVERAGE, SAUCE, MARINADE, FINGERFOOD, SNACK, DRINK
fun MealTypes.toMealCategory(mealType: MealTypes): MealCategory {
    return when (mealType) {
        MealTypes.MAINCOURSE -> MealCategory("Main Course", "https://spoonacular.com/recipeImages/716381-312x231.jpg")
        MealTypes.SIDEDISH -> MealCategory("Side Dish", "https://spoonacular.com/recipeImages/766453-312x231.jpg")
        MealTypes.DESSERT -> MealCategory("Dessert", "https://spoonacular.com/recipeImages/658007-312x231.jpg")
        MealTypes.APPETIZER -> MealCategory("Appetizer", "https://spoonacular.com/recipeImages/716406-312x231.jpg")
//        MealTypes.SALAD -> MealCategory("Salad", "https://spoonacular.com/recipeImages/782600-312x231.jpg")
//        MealTypes.BREAD -> MealCategory("Bread", "https://spoonacular.com/recipeImages/632347-312x231.jpg")
//        MealTypes.BREAKFAST -> MealCategory("Breakfast", "https://spoonacular.com/recipeImages/782619-312x231.png")
//        MealTypes.SOUP -> MealCategory("Soup", "https://spoonacular.com/recipeImages/715415-312x231.jpg")
//        MealTypes.BEVERAGE -> MealCategory("Beverage", "https://spoonacular.com/recipeImages/756814-312x231.jpg")
//        MealTypes.SAUCE -> MealCategory("Sauce", "https://spoonacular.com/recipeImages/660228-312x231.jpg")
//        MealTypes.MARINADE -> MealCategory("Marinade", "https://spoonacular.com/recipeImages/715567-312x231.jpg")
//        MealTypes.FINGERFOOD -> MealCategory("Fingerfood", "https://spoonacular.com/recipeImages/642129-312x231.jpg")
//        MealTypes.SNACK -> MealCategory("Snack", "https://spoonacular.com/recipeImages/715543-312x231.jpg")
//        MealTypes.DRINK -> MealCategory("Drink", "https://spoonacular.com/recipeImages/715497-312x231.jpg")
    }
}

fun MealTypes.toMealCategoryList(): List<MealCategory> {
    val list = mutableListOf<MealCategory>()

    MealTypes.entries.forEach {
        list.add(it.toMealCategory(it))
    }

    return list
}
