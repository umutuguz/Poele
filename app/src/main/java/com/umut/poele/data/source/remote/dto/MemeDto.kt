package com.umut.poele.data.source.remote.dto

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json




//data class MemeDto(
//    @SerializedName("id")
//    val id: String,
//    @SerializedName("name")
//    val name: String,
//    @SerializedName("url")
//    val url: String,
//    @SerializedName("width")
//    val width: Int,
//    @SerializedName("height")
//    val height: Int,
//    @SerializedName("box_count")
//    val boxCount: Int,
//    @SerializedName("captions")
//    val captions: Int
//)

data class MemeDto(
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "width")
    val width: Int,
    @Json(name = "height")
    val height: Int,
    @Json(name = "box_count")
    val boxCount: Int,
    @Json(name = "captions")
    val captions: Int
)
