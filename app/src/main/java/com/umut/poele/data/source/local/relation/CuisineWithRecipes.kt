package com.umut.poele.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.data.source.local.entity.CuisineEntity
import com.umut.poele.data.source.local.entity.RecipeEntity

class CuisineWithRecipes(
    @Embedded val cuisine: CuisineEntity,
    @Relation(
        parentColumn = "cuisine_title",
        entityColumn = "recipe_id",
        associateBy = Junction(com.umut.poele.data.source.local.relation.RecipeCuisineCrossRef::class)
    )
    val recipes: List<RecipeEntity>
)
