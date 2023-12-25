package com.umut.poele.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.umut.poele.data.source.local.entity.DirectionEntity
import com.umut.poele.data.source.local.entity.RecipeEntity

data class RecipeAndDirection(
    @Embedded val recipe: RecipeEntity,
    @Relation(
        parentColumn = "recipe_id",
        entityColumn = "direction_id"
        )
    val direction: DirectionEntity
)
