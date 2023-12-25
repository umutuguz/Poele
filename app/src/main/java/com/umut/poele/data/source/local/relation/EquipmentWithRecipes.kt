package com.umut.poele.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.data.source.local.entity.EquipmentEntity
import com.umut.poele.data.source.local.entity.RecipeEntity

data class EquipmentWithRecipes(
    @Embedded val equipment: EquipmentEntity,
    @Relation(
        parentColumn = "equipment_title",
        entityColumn = "recipe_id",
        associateBy = Junction(com.umut.poele.data.source.local.relation.RecipeEquipmentCrossRef::class)
    )
    val recipes: List<RecipeEntity>
)
