package com.umut.poele.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cuisine")
data class CuisineEntity(
    @PrimaryKey @ColumnInfo("cuisine_title") val cuisineTitle: String
)
