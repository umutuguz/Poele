package com.umut.poele.model

import androidx.annotation.DrawableRes
import com.umut.poele.ui.base.ListAdapterItem

data class Ingredient(
    val id: Int,
    @DrawableRes val imageId: Int,
    val name: String,
    val amount: Double,
    val unit: String,
) : ListAdapterItem
