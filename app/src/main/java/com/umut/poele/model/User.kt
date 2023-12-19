package com.umut.poele.model

import com.umut.poele.ui.base.ListAdapterItem

data class User(
    val id: Int,
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val address: Address,
    val profilePhotoUrl: ImageUrl,
    val dailyMenu: List<MenuCardModel>,
    val fridge: List<Supply>,
    val recipeModels: List<RecipeModel>
) : ListAdapterItem
