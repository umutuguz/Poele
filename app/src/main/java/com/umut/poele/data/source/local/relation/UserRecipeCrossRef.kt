package com.umut.poele.data.source.local.relation

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["user_id", "recipe_id"])
data class UserRecipeCrossRef(
    @ColumnInfo("user_id")val userId: Int,
    @ColumnInfo("recipe_id") val recipeId: Int
)
