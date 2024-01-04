package com.umut.poele.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int = -1,
    val email: String = "",
    val password: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val phone: String = "",
    val address: Address = Address(),
    val profilePhotoUrl: ImageUrl = -1,
    val dailyMenu: List<MenuCard> = emptyList(),
    val fridge: List<Supply> = emptyList(),
    val recipes: List<RecipeModel> = emptyList()
) : Parcelable
