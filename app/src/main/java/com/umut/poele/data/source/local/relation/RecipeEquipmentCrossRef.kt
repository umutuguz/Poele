package com.umut.poele.data.source.local.relation

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["recipe_id", "equipment_title"])
class RecipeEquipmentCrossRef(
    @ColumnInfo("recipe_id") val recipeId: Int,
    @ColumnInfo("equipment_title") val equipmentTitle: String
)
