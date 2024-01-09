package com.umut.poele.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Address(
    val id: Int = -1,
    val title: String = "",
    val addressImageUrl: ImageUrl = -1,
    val city:String = "",
    val district: String = "",
    val neighborhood: String = "",
    val street: String = "",
    val buildingName: String = "",
    val buildingNumber: Int = 0,
    val floorNumber: Int = 0,
    val doorNumber: Int = 0,
    val postalCode: Int = 0
) : Parcelable
