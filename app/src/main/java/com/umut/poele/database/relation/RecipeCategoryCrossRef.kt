package com.umut.poele.database.relation

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["recipe_id", "recipe_category_title"])
class RecipeCategoryCrossRef(
    @ColumnInfo("recipe_id") val recipeId: Int,
    @ColumnInfo("recipe_category_title") val recipeCategoryTitle: String
)
