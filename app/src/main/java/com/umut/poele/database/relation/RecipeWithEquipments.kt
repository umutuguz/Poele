package com.umut.poele.database.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.database.equipment.Equipment
import com.umut.poele.database.recipe.Recipe

data class RecipeWithEquipments(
    @Embedded val recipe: Recipe,
    @Relation(
        parentColumn = "recipe_id",
        entityColumn = "equipment_title",
        associateBy = Junction(RecipeEquipmentCrossRef::class)
    )
    val equipments: List<Equipment>
)
