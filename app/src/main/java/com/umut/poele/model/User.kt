package com.umut.poele.model

import androidx.annotation.DrawableRes
import com.umut.poele.ui.base.ListAdapterItem

data class User(
    val id: Int,
    val email: String,
    val password: String,
    val name: String,
    val surName: String,
    val phone: String,
    val address: Address,
    val profilePhotoUrl: ImageUrl,
    val dailyMenu: List<MenuCard>,
    val fridge: List<Supply>,
    val recipes: List<Recipe>
) : ListAdapterItem
