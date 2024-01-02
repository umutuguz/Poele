package com.umut.poele.data.source.remote.dto

import com.squareup.moshi.Json

class RecipeBasicDto(
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "imageType")
    val imageType: String
)
