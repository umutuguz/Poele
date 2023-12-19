package com.umut.poele.database.cuisine

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cuisine(
    @PrimaryKey @ColumnInfo("cuisine_title") val cuisineTitle: String
)
