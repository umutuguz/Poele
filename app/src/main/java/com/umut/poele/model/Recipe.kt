package com.umut.poele.model

import com.umut.poele.ui.base.ListAdapterItem
import com.umut.poele.util.Levels

data class Recipe(
    val id: Int,
    val title: String,
    val imageUrl: ImageUrl,
    val chefName: String,
    val category: List<String>,
    val description: String,
    val prepTime: Int,
    val servings: Int,
    val difficultyLevel: Levels,
    val cuisine: List<String>,
    val isFavorite: Boolean,
    val isVegan: Boolean,
    val equipments: List<String>,
    val directions: List<String>,
    val ingredients: List<Supply>
) : ListAdapterItem
