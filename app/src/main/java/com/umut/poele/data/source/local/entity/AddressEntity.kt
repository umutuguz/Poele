package com.umut.poele.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.umut.poele.domain.model.ImageUrl

@Entity(tableName = "address")
data class AddressEntity(
    @PrimaryKey @ColumnInfo("address_id") val id: Int,
    @ColumnInfo ("title") val title: String,
    @ColumnInfo("address_image_url") val addressImageUrl: ImageUrl,
    @ColumnInfo("city") val city: String,
    @ColumnInfo("district") val district: String,
    @ColumnInfo("neighborhood") val neighborhood: String,
    @ColumnInfo("street") val street: String,
    @ColumnInfo("building_name") val buildingName: String,
    @ColumnInfo("building_number") val buildingNumber: Int,
    @ColumnInfo("floor_number") val floorNumber: Int,
    @ColumnInfo("door_number") val doorNumber: Int,
    @ColumnInfo("postal_code") val postalCode: Int,
    @ColumnInfo("user_id") val userId: Int,
)
