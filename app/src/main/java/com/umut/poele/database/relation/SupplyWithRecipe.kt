package com.umut.poele.database.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.database.recipe.Recipe
import com.umut.poele.database.supply.Supply
import com.umut.poele.database.user.User


data class SupplyWithRecipe(
    @Embedded val supply: Supply,
    @Relation(
        parentColumn = "supply_id",
        entityColumn = "recipe_id",
        associateBy = Junction(RecipeSupplyCrossRef::class)
    )
    val recipes: List<Recipe>
)
