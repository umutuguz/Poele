package com.umut.poele.data.source.remote.response

import com.squareup.moshi.Json
import com.umut.poele.data.source.remote.dto.RecipeBasicDto

data class RecipeBasicResponse(
    @Json(name = "results")
    val results: List<RecipeBasicDto>,
    @Json(name = "offset")
    val offset: Int,
    @Json(name = "number")
    val number: Int,
    @Json(name = "totalResults")
    val totalResults: Int
)
