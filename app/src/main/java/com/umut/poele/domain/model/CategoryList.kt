package com.umut.poele.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryList(
    val recipeList : List<RecipeBasic> = emptyList()
) : Parcelable
