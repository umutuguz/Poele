package com.umut.poele.database.category

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("recipe_category")
data class RecipeCategory(
    @PrimaryKey @ColumnInfo("recipe_category_title") val recipeCategoryTitle: String,
) : Parcelable
