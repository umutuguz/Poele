package com.umut.poele.domain.use_case

import android.util.Log
import com.umut.poele.data.source.local.dao.RecipeDao
import com.umut.poele.data.source.local.entity.ShopListEntity
import com.umut.poele.data.source.local.entity.toRecipeBasic
import com.umut.poele.data.source.remote.dto.Nutrition
import com.umut.poele.data.source.remote.dto.toEquipment
import com.umut.poele.data.source.remote.dto.toRecipe
import com.umut.poele.domain.model.CategoryList
import com.umut.poele.domain.model.Equipment
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.domain.model.RecipeModel
import com.umut.poele.domain.repository.RecipeRepository
import com.umut.poele.util.Resource
import com.umut.poele.util.extension.toRecipeBasic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(private val recipeRepository: RecipeRepository) {

    suspend fun getRecipes(number: Int): Resource<List<RecipeBasic>> {
        var recipes = emptyList<RecipeBasic>()
        withContext(Dispatchers.IO) {
            try {
                recipes = recipeRepository.getRecipes(number).map { it.toRecipeBasic() }
            } catch (e: retrofit2.HttpException) {
                Log.e("HttpException", e.localizedMessage ?: "Http Error occurred")
            } catch (e: IOException) {
                Log.e("IOException", e.localizedMessage ?: "IO Error occured")
            }
        }
        return Resource.Success(recipes)
    }

    suspend fun getRecipeInfo(id: Int, includeNutrition: Boolean): Resource<RecipeBasic> {
        var recipe = RecipeBasic()
        withContext(Dispatchers.IO) {
            try {
                recipe = recipeRepository.getRecipeInfo(id, includeNutrition).toRecipe()
            } catch (e: retrofit2.HttpException) {
                Log.e("HttpException", e.localizedMessage ?: "Http Error occurred")
            } catch (e: IOException) {
                Log.e("IOException", e.localizedMessage ?: "IO Error occured")
            }
        }
        return Resource.Success(recipe)
    }

    suspend fun getRecipesWithType(info: Boolean,type: String, number: Int): Resource<CategoryList> {
        var recipeList = emptyList<RecipeBasic>()
        withContext(Dispatchers.IO) {
            try {
                recipeList = recipeRepository.getRecipeWithType(info, type, number).map { it.toRecipeBasic() }
            } catch (e: retrofit2.HttpException) {
                Log.e("HttpException", e.localizedMessage ?: "Http Error occurred")
            } catch (e: IOException) {
                Log.e("IOException", e.localizedMessage ?: "IO Error occured")
            }
        }
        return Resource.Success(CategoryList(recipeList))
    }

    suspend fun getEquipmentWithId(id: Int): Resource<List<Equipment>> {
        var equipmentList = emptyList<Equipment>()
        withContext(Dispatchers.IO) {
            try {
                equipmentList = recipeRepository.getEquipmentWithId(id).map { it.toEquipment() }
            } catch (e: retrofit2.HttpException) {
                Log.e("HttpException", e.localizedMessage ?: "Http Error occurred")
            } catch (e: IOException) {
                Log.e("IOException", e.localizedMessage ?: "IO Error occured")
            }
        }
        return Resource.Success(equipmentList)
    }

    suspend fun getShopList() : Resource<List<RecipeBasic>> {
        var shopList = emptyList<RecipeBasic>()
        withContext(Dispatchers.IO) {
            try {
                shopList = recipeRepository.getShopList().map { it.toRecipeBasic() }
            } catch (e: IOException) {
                Log.e("IOException", e.localizedMessage ?: "IO Error occured")
            }
        }
        return Resource.Success(shopList)
    }

    suspend fun upsertRecipeToShopList(recipeBasic: RecipeBasic) {
        val shopListItem = ShopListEntity(
            recipeBasic.id,
            recipeBasic.title,
            recipeBasic.imageUrl,
            recipeBasic.prepTime,
            recipeBasic.servings,
            recipeBasic.difficultyLevel.toString(),
            recipeBasic.chefName)
        withContext(Dispatchers.IO) {
            recipeRepository.upsertShopList(shopListItem)
        }
    }

    suspend fun deleteShopList(): Boolean{
        var result = false
        withContext(Dispatchers.IO) {
            result = recipeRepository.deleteAllRecipesFromShopList()
        }
        return result
    }
}
