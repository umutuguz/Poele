package com.umut.poele.domain.repository

import com.umut.poele.data.source.remote.dto.RecipeDto
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {

    suspend fun getRecipes(): Flow<List<RecipeDto>>
}
