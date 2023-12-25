package com.umut.poele.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.data.source.local.entity.CuisineEntity
import com.umut.poele.data.source.local.entity.RecipeEntity

data class RecipeWithCuisines(
    @Embedded val recipe: RecipeEntity,
    @Relation(
        parentColumn = "recipe_id",
        entityColumn = "cuisine_title",
        associateBy = Junction(RecipeCuisineCrossRef::class)
    )
    val cuisines: List<CuisineEntity>
)
