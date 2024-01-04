package com.umut.poele.data.source.remote.dto

import com.squareup.moshi.Json
import com.umut.poele.domain.model.Equipment

fun EquipmentDto.toEquipment() : Equipment {
    return Equipment(name)
}

data class EquipmentDto(
    @Json(name = "image") val image: String,
    @Json(name = "name") val name: String
)
