package com.umut.poele.data

import com.umut.poele.R
import com.umut.poele.model.FoodCategory

class FoodCategoryDataSource {

    fun loadFoodCategory(): List<FoodCategory> {
        return listOf<FoodCategory>(
            FoodCategory("Pasta", R.drawable.pasta),
            FoodCategory("Fish", R.drawable.pasta),
            FoodCategory("Meat", R.drawable.pasta),
            FoodCategory("Chicken", R.drawable.pasta),
            FoodCategory("Vegetable", R.drawable.pasta),
            FoodCategory("Rice", R.drawable.pasta),
            FoodCategory("Pasta", R.drawable.pasta),
            FoodCategory("Pasta", R.drawable.pasta),
            FoodCategory("Pasta", R.drawable.pasta),
            FoodCategory("Pasta", R.drawable.pasta)
        )
    }
}
