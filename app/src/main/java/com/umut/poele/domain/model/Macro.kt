package com.umut.poele.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Macro(
    var calorie: Double = -1.0,
    var fat: Double = -1.0,
    var carb: Double = -1.0,
    var fiber: Double = -1.0,
    var protein: Double = -1.0,
) :Parcelable
