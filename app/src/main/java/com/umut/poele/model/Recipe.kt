package com.umut.poele.model

import androidx.annotation.DrawableRes
import com.umut.poele.ui.base.ListAdapterItem

data class Recipe(
    val id: Int,
    @DrawableRes val imageId: Int,
    val name: String,
    val chefName: String,
    val category: String,
    val description: String,
    val time: Int,
    val people: Int,
    val weight: Int,
    val equipments: List<String>,
    val calorie: Double,
    val protein: Double,
    val carb: Double,
    val fat: Double,
    val fiber: Double,
    val ingredients: List<Ingredient>,
    val directions: List<String>
) : ListAdapterItem
