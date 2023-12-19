package com.umut.poele.database.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.database.equipment.Equipment
import com.umut.poele.database.recipe.Recipe

data class EquipmentWithRecipes(
    @Embedded val equipment: Equipment,
    @Relation(
        parentColumn = "equipment_title",
        entityColumn = "recipe_id",
        associateBy = Junction(RecipeEquipmentCrossRef::class)
    )
    val recipes: List<Recipe>
)
