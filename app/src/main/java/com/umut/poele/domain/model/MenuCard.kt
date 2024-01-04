package com.umut.poele.domain.model

import android.os.Parcelable
import com.umut.poele.util.Meals
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuCard(
    val menuTitle: Meals = Meals.UNDETERMINED,
    val chefName: String = "",
    val primaryMealName: String = "",
    val secondaryMealName: String = "",
    val tertiaryMealName: String = ""
) : Parcelable
