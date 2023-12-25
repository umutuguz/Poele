package com.umut.poele.domain.model

import android.os.Parcelable
import com.umut.poele.ui.base.ListAdapterItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class Macro(
    val calorie: Double,
    val fat: Double,
    val carb: Double,
    val fiber: Double,
    val protein: Double,
) : ListAdapterItem, Parcelable
