package com.umut.poele.domain.model

import android.os.Parcelable
import com.umut.poele.util.Levels
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeBasic(
    val id: Int = -1,
    val title: String = "",
    val imageUrl: String = "",
    val chefName: String = "",
    val category: List<String> = emptyList(),
    val description: String = "",
    val prepTime: Int = -1,
    val servings: Int = -1,
    val difficultyLevel: Levels = Levels.UNDETERMINED,
    val cuisine: List<String> = emptyList(),
    val isFavorite: Boolean = false,
    val isVegan: Boolean = false,
    val equipments: List<Equipment> = emptyList(),
    val directions: List<String> = emptyList(),
    val ingredients: List<Supply> = emptyList(),
    val macro: Macro = Macro()
) : Parcelable
