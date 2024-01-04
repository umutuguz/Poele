package com.umut.poele.data.source.remote.response

import com.squareup.moshi.Json
import com.umut.poele.data.source.remote.dto.EquipmentDto

data class EquipmentResponse(
    @Json(name = "equipment")
    val equipment: List<EquipmentDto>
)
