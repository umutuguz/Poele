package com.umut.poele.data.source.remote

import com.umut.poele.data.source.remote.dto.MemeDto
import com.umut.poele.data.source.remote.dto.RecipeDto
import retrofit2.http.GET

interface PoeleApiService {

    @GET("/get_memes")
    suspend fun getRecipes(id: Int): List<MemeDto>
}
