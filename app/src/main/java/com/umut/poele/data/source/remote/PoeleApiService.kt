package com.umut.poele.data.source.remote

import com.umut.poele.data.source.remote.dto.RecipeDto
import com.umut.poele.data.source.remote.response.EquipmentResponse
import com.umut.poele.data.source.remote.response.MealPlannerResponse
import com.umut.poele.data.source.remote.response.RecipeBasicResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PoeleApiService {

    @GET("/recipes/complexSearch")
    suspend fun getRecipes(
        @Query("addRecipeInformation") addRecipeInformation: Boolean = true,
        @Query("number") number: Int = 10) : RecipeBasicResponse

    @GET("/recipes/{id}/information")
    suspend fun getRecipeInfo(
        @Path(value = "id") id: Int,
        @Query("includeNutrition") includeNutrition : Boolean = true)
    : RecipeDto

    @GET("/recipes/complexSearch")
    suspend fun getRecipeWithType(
        @Query("addRecipeInformation")
        addRecipeInformation: Boolean = true,
        @Query("type")
        type: String,
        @Query("number")
        number: Int = 15,
        @Query("sort")
        sort: String = "protein",
        @Query("sortDirection")
        sortDirection: String = "desc"
    ) : RecipeBasicResponse

    @GET("/mealplanner/generate")
    suspend fun getMenuCard(
        @Query("timeFrame")
        timeFrame: String = "week",
        @Query("targetCalories")
        targetCalories: Int = 2000
    ) : MealPlannerResponse

    @GET("/recipes/{id}/equipmentWidget.json")
    suspend fun getEquipment(@Path("id") id: Int) : EquipmentResponse

}
