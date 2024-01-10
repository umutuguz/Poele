package com.umut.poele.data.source.remote.dto

import com.squareup.moshi.Json

data class RecipeBasicDto(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "preparationMinutes")
    val preparationMinutes: Int?,
    @Json(name = "servings")
    val servings: Int?,
    @Json(name = "sourceName")
    val sourceName: String?,
    @Json(name = "spoonacularScore")
    val spoonacularScore: Double?,
    @Json(name = "imageType")
    val imageType: String?
)
