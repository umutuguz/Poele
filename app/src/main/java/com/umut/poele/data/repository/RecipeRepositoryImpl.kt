package com.umut.poele.data.repository

import com.umut.poele.data.source.remote.PoeleApiService
import com.umut.poele.data.source.remote.dto.RecipeDto
import com.umut.poele.data.source.remote.dto.RecipeBasicDto
import com.umut.poele.domain.repository.RecipeRepository

class RecipeRepositoryImpl(private val api: PoeleApiService): RecipeRepository {

    override suspend fun getRecipes(number: Int): List<RecipeBasicDto> {
        val result = api.getRecipes(number)
        return if ( result.totalResults != 0) {
            result.results
        } else
        {
            emptyList()
        }
    }

    override suspend fun getRecipeInfo(id: Int, includeNutrition: Boolean): RecipeDto {
        return api.getRecipeInfo(id, includeNutrition)
    }

    override suspend fun getRecipeWithType(type: String): List<RecipeBasicDto> {
        val result = api.getRecipeWithType(type)
        return if (result.totalResults != 0) {
            result.results
        }else {
            emptyList()
        }
    }
}
