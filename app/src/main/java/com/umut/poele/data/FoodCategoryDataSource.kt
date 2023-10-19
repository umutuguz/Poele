package com.umut.poele.data

import com.umut.poele.R
import com.umut.poele.model.FoodCategory

class FoodCategoryDataSource {

    fun loadFoodCategory(): List<FoodCategory> {
        return listOf<FoodCategory>(
            FoodCategory("Breakfast", R.drawable.pasta),
            FoodCategory("Brunch", R.drawable.pasta),
            FoodCategory("Lunch", R.drawable.pasta),
            FoodCategory("Dinner", R.drawable.pasta),
            FoodCategory("Pancakes", R.drawable.pasta),
            FoodCategory("Sandwiches", R.drawable.pasta),
            FoodCategory("Appetisers", R.drawable.pasta),
            FoodCategory("Soups", R.drawable.pasta),
            FoodCategory("Salads", R.drawable.pasta),
            FoodCategory("Sides", R.drawable.pasta),
            FoodCategory("Snacks", R.drawable.pasta),
            FoodCategory("Burgers", R.drawable.pasta),
            FoodCategory("Pizza", R.drawable.pasta),
            FoodCategory("Lamb", R.drawable.pasta),
            FoodCategory("Chicken", R.drawable.pasta),
            FoodCategory("Seafood", R.drawable.pasta),
            FoodCategory("Rice", R.drawable.pasta),
            FoodCategory("Noodles", R.drawable.pasta),
            FoodCategory("Pasta", R.drawable.pasta),
            FoodCategory("Sausages", R.drawable.pasta),
            FoodCategory("Beef", R.drawable.pasta),
            FoodCategory("Cookies", R.drawable.pasta),
            FoodCategory("Deserts", R.drawable.pasta),
            FoodCategory("Meat", R.drawable.pasta),
            FoodCategory("Drinks", R.drawable.pasta),
            FoodCategory("Cocktails", R.drawable.pasta)
        )
    }
}
