package com.umut.poele.model

import androidx.annotation.DrawableRes
import com.umut.poele.ui.base.ListAdapterItem

data class MenuCard(
    val menuTitle: String,
    val chefName: String,
    val primaryMealName: String,
    val secondaryMealName: String,
    val tertiaryMealName: String,
    @DrawableRes val imageSourceId: Int,
) : ListAdapterItem
