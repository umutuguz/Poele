package com.umut.poele.data.repository

import android.util.Log
import com.umut.poele.data.source.remote.PoeleApiService
import com.umut.poele.data.source.remote.dto.RecipeDto
import com.umut.poele.data.source.local.dao.RecipeDao
import com.umut.poele.data.source.local.dao.UserDao
import com.umut.poele.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class RecipeRepositoryImpl(poeleApiService: PoeleApiService, recipeDao: RecipeDao, userDao: UserDao): RecipeRepository {

    override suspend fun getRecipes(): Flow<List<RecipeDto>> {
        Log.i("umutcan", "RecipeRepositoryImpl")
        return flowOf(emptyList())
    }
}
