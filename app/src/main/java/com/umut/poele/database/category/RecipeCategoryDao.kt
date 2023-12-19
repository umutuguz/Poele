package com.umut.poele.database.category

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.umut.poele.database.address.Address

@Dao
interface RecipeCategoryDao {

    @Upsert
    suspend fun upsertRecipeCategory(recipeCategory: RecipeCategory)
}
