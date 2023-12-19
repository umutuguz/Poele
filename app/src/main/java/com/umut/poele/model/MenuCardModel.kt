package com.umut.poele.model

import com.umut.poele.ui.base.ListAdapterItem
import com.umut.poele.util.Meals

data class MenuCardModel(
    val menuTitle: Meals,
    val chefName: String,
    val primaryMealName: String,
    val secondaryMealName: String,
    val tertiaryMealName: String
) : ListAdapterItem
