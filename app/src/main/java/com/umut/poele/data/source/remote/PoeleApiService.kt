package com.umut.poele.data.source.remote

import com.umut.poele.data.source.remote.dto.RecipeDto
import com.umut.poele.data.source.remote.response.MemeResponse
import com.umut.poele.data.source.remote.response.RecipeBasicResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PoeleApiService {

    @GET("/get_memes")
    suspend fun getMemes(): MemeResponse

    @GET("/recipes/complexSearch")
    suspend fun getRecipes(@Query("number") number: Int = 10) : RecipeBasicResponse

    @GET("/recipes/{id}/information")
    suspend fun getRecipeInfo(@Path(value = "id") id: Int, @Query("includeNutrition") includeNutrition : Boolean = false) : RecipeDto

    @GET("/recipes/complexSearch")
    suspend fun getRecipeWithType(@Query("type") type: String) : RecipeBasicResponse
}
