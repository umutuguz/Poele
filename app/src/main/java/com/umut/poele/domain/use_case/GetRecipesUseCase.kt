package com.umut.poele.domain.use_case

import android.util.Log
import com.umut.poele.data.source.remote.dto.Nutrition
import com.umut.poele.data.source.remote.dto.toRecipe
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

    suspend fun getRecipesWithType(type: String) : Resource<List<RecipeBasic>> {
        var recipeList = emptyList<RecipeBasic>()
        withContext(Dispatchers.IO) {
            try {
                recipeList = recipeRepository.getRecipeWithType(type).map { it.toRecipeBasic() }
            } catch (e: retrofit2.HttpException) {
                Log.e("HttpException", e.localizedMessage ?: "Http Error occurred")
            } catch (e: IOException) {
                Log.e("IOException", e.localizedMessage ?: "IO Error occured")
            }
        }
        return Resource.Success(recipeList)
    }
}
