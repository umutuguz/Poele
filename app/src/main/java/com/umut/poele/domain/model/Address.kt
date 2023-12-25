package com.umut.poele.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Address(
    val id: Int,
    val title: String,
    val addressImageUrl: ImageUrl,
    val city:String,
    val district: String,
    val neighborhood: String,
    val street: String,
    val buildingName: String,
    val buildingNumber: Int,
    val floorNumber: Int,
    val doorNumber: Int,
    val postalCode: Int
) : Parcelable {
}
