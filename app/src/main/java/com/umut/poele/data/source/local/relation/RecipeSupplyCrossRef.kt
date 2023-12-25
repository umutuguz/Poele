package com.umut.poele.data.source.local.relation

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["recipe_id", "supply_id"])
class RecipeSupplyCrossRef(
    @ColumnInfo("recipe_id") val recipeId: Int,
    @ColumnInfo("supply_id") val supplyId: Int
)
