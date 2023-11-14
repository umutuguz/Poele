package com.umut.poele.model

data class Address(
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
) {
}
