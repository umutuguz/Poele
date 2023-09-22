package com.umut.poele.model

import androidx.annotation.DrawableRes
import com.umut.poele.ui.base.ListAdapterItem

data class Recipe(
    val id : Int,
    val name : String,
    val chefName: String,
    val category: String,
    val time: Int,
    val people: Int,
    val weight: Int,
    @DrawableRes val imageId: Int
): ListAdapterItem{

}
