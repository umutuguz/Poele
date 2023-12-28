package com.umut.poele.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.umut.poele.data.source.remote.dto.RecipeDto

data class RecipeResponse(

    @SerializedName("status_code")
    var status: Int,

    @SerializedName("message")
    var message: String,

    @SerializedName("recipes")
    var posts: List<RecipeDto>
)
