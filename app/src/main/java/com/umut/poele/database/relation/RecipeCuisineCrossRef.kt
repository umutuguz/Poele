package com.umut.poele.database.relation

import androidx.room.ColumnInfo
import androidx.room.Entity


@Entity(primaryKeys = ["recipe_id", "cuisine_title"])
class RecipeCuisineCrossRef(
    @ColumnInfo("recipe_id") val recipeId: Int,
    @ColumnInfo("cuisine_title") val cuisineTitle: String
)
