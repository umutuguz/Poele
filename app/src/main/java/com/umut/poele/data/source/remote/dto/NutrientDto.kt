package com.umut.poele.data.source.remote.dto

import com.squareup.moshi.Json

data class NutrientDto(
    @Json(name = "calories")
    val calories: Double,
    @Json(name = "protein")
    val protein: Double,
    @Json(name = "fat")
    val fat: Double,
    @Json(name = "carbohydrates")
    val carbohydrates: Double
)
