package com.umut.poele.domain.repository

import com.umut.poele.data.source.remote.dto.RecipeBasicDto
import com.umut.poele.data.source.remote.dto.RecipeDto

interface RecipeRepository {

    suspend fun getRecipes(number: Int): List<RecipeBasicDto>
    suspend fun getRecipeInfo(id: Int, includeNutrition: Boolean) : RecipeDto

    suspend fun getRecipeWithType(type: String) : List<RecipeBasicDto>
}
