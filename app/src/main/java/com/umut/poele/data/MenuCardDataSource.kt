package com.umut.poele.data

import com.umut.poele.R
import com.umut.poele.model.MenuCard

class MenuCardDataSource {

    fun loadMenuCards(): List<MenuCard>{
        return listOf<MenuCard>(
            MenuCard("Dinner", "Umut", "Lasagne", "French Fries", "Yogurt", R.drawable.herbs),
            MenuCard("Dinner", "Umut", "Lasagne", "French Fries", "Yogurt", R.drawable.herbs),
            MenuCard("Dinner", "Umut", "Lasagne", "French Fries", "Yogurt", R.drawable.herbs),
            MenuCard("Dinner", "Umut", "Lasagne", "French Fries", "Yogurt", R.drawable.herbs)
        )
    }
}
