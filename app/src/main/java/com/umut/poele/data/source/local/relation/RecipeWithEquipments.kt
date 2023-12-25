package com.umut.poele.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.data.source.local.entity.EquipmentEntity
import com.umut.poele.data.source.local.entity.RecipeEntity

data class RecipeWithEquipments(
    @Embedded val recipe: RecipeEntity,
    @Relation(
        parentColumn = "recipe_id",
        entityColumn = "equipment_title",
        associateBy = Junction(RecipeEquipmentCrossRef::class)
    )
    val equipments: List<EquipmentEntity>
)
