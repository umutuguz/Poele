package com.umut.poele.data.source.remote

import com.umut.poele.data.source.remote.dto.RecipeDto
import retrofit2.http.GET

interface PoeleApiService {

    @GET("/recipes")
    suspend fun getRecipes(): List<RecipeDto>
}
