package com.umut.poele.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MealCategory(
    val title: String = "",
    val image: String = ""
) : Parcelable
