package com.umut.poele.model

import com.umut.poele.ui.base.ListAdapterItem

data class Macro(
    val calorie: Double,
    val fat: Double,
    val carb: Double,
    val fiber: Double,
    val protein: Double,
) : ListAdapterItem
