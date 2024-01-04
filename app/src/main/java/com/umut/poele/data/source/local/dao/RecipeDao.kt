package com.umut.poele.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.umut.poele.data.source.local.entity.ShopListEntity
import com.umut.poele.data.source.local.entity.CuisineEntity
import com.umut.poele.data.source.local.entity.DirectionEntity
import com.umut.poele.data.source.local.entity.EquipmentEntity
import com.umut.poele.data.source.local.entity.RecipeCategoryEntity
import com.umut.poele.data.source.local.entity.RecipeEntity
import com.umut.poele.data.source.local.relation.RecipeCategoryCrossRef
import com.umut.poele.data.source.local.relation.RecipeCategoryWithRecipes
import com.umut.poele.data.source.local.relation.RecipeCuisineCrossRef
import com.umut.poele.data.source.local.relation.RecipeEquipmentCrossRef
import com.umut.poele.data.source.local.relation.RecipeSupplyCrossRef
import com.umut.poele.data.source.local.relation.UserWithRecipeCategoriesWithRecipes
import com.umut.poele.data.source.local.relation.UserWithRecipes
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipe")
    fun getAllRecipes(): Flow<List<RecipeEntity>>

    @Query("SELECT * FROM recipe_category ORDER BY recipe_category_title ASC")
    fun getAllRecipeCategories(): Flow<List<RecipeCategoryEntity>>

    @Transaction
    @Query("SELECT * FROM user WHERE user_id = :userId")
    fun getAllRecipesOfUser(userId: Int): Flow<UserWithRecipes>

    @Transaction
    @Query("SELECT * FROM recipe_category WHERE recipe_category_title = :recipeCategoryTitle")
    fun getRecipesWithCategory(recipeCategoryTitle: String): Flow<RecipeCategoryWithRecipes>

    @Transaction
    @Query("SELECT * FROM user")
    fun getUsersWithRecipesAndCategories(): Flow<List<UserWithRecipeCategoriesWithRecipes>>

    @Query("SELECT * FROM shoplist ORDER BY recipe_title ASC")
    fun getShopList(): List<ShopListEntity>

    @Delete
    suspend fun deleteRecipeFromShopList(shopListEntity: ShopListEntity)
    @Query("DELETE FROM shoplist")
    suspend fun deleteAllRecipesFromShopList()
    @Upsert
    suspend fun upsertRecipe(recipe: RecipeEntity)
    @Upsert
    suspend fun upsertRecipeToShopList(shopListEntity: ShopListEntity)
    @Upsert
    suspend fun upsertRecipeCategoryCrossRef(crossRef: RecipeCategoryCrossRef)
    @Upsert
    suspend fun upsertRecipeCuisineCrossRef(crossRef: RecipeCuisineCrossRef)
    @Upsert
    suspend fun upsertRecipeEquipmentCrossRef(crossRef: RecipeEquipmentCrossRef)
    @Upsert
    suspend fun upsertRecipeSupplyCrossRef(crossRef: RecipeSupplyCrossRef)
    @Upsert
    suspend fun upsertDirection(direction: DirectionEntity)
    @Upsert
    suspend fun upsertRecipeCategory(recipeCategory: RecipeCategoryEntity)
    @Upsert
    suspend fun upsertCuisine(cuisine: CuisineEntity)
    @Upsert
    suspend fun upsertEquipment(equipment: EquipmentEntity)
}
