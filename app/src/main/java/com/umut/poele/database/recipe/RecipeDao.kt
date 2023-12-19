package com.umut.poele.database.recipe

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.umut.poele.database.category.RecipeCategory
import com.umut.poele.database.relation.RecipeCategoryCrossRef
import com.umut.poele.database.relation.RecipeCategoryWithRecipes
import com.umut.poele.database.relation.RecipeCuisineCrossRef
import com.umut.poele.database.relation.RecipeEquipmentCrossRef
import com.umut.poele.database.relation.RecipeSupplyCrossRef
import com.umut.poele.database.relation.UserWithRecipes
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipe")
    fun getAllRecipes(): Flow<List<Recipe>>

    @Query("SELECT * FROM recipe_category ORDER BY recipe_category_title ASC")
    fun getAllRecipeCategories(): Flow<List<RecipeCategory>>

    @Transaction
    @Query("SELECT * FROM user WHERE user_id = :userId")
    fun getAllRecipesOfUser(userId: Int): Flow<UserWithRecipes>

    @Transaction
    @Query("SELECT * FROM recipe_category WHERE recipe_category_title = :recipeCategoryTitle")
    fun getRecipesWithCategory(recipeCategoryTitle: String): Flow<RecipeCategoryWithRecipes>

    @Upsert
    suspend fun upsertRecipe(recipe: Recipe)
    @Upsert
    suspend fun upsertRecipeCategoryCrossRef(crossRef: RecipeCategoryCrossRef)
    @Upsert
    suspend fun upsertRecipeCuisineCrossRef(crossRef: RecipeCuisineCrossRef)
    @Upsert
    suspend fun upsertRecipeEquipmentCrossRef(crossRef: RecipeEquipmentCrossRef)
    @Upsert
    suspend fun upsertRecipeSupplyCrossRef(crossRef: RecipeSupplyCrossRef)
}
