package com.umut.poele.model

import com.umut.poele.ui.base.ListAdapterItem

data class Recipe(
    val id : Int,
    val name : String,
    val chefName: String,
    val category: String,
    val time: Int,
    val people: Int,
    val weight: Int
): ListAdapterItem{

}
