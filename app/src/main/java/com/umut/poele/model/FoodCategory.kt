package com.umut.poele.model

import androidx.annotation.DrawableRes
import com.umut.poele.ui.base.ListAdapterItem

data class FoodCategory(val name: String, @DrawableRes val imageResourceId: Int) : ListAdapterItem {
}
