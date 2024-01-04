package com.umut.poele.data.source.remote.dto

import com.squareup.moshi.Json
import com.umut.poele.domain.model.MenuCard

data class MealDto(
    @Json(name = "id")
    val id: Int,
    @Json(name = "imageType")
    val imageType: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "readyInMinutes")
    val readyInMinutes: Int,
    @Json(name = "servings")
    val servings: Int,
    @Json(name = "sourceUrl")
    val sourceUrl: String
)
