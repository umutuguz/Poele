package com.umut.poele.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "direction")
data class DirectionEntity(
    @PrimaryKey @ColumnInfo("direction_id") val directionId: Int,
    @ColumnInfo("first_direction") val firstDirection: String,
    @ColumnInfo("second_direction") val secondDirection: String,
    @ColumnInfo("third_direction") val thirdDirection: String,
    @ColumnInfo("fourth_direction") val fourthDirection: String,
    @ColumnInfo("fifth_direction") val fifthDirection: String,
    @ColumnInfo("sixth_direction") val sixthDirection: String,
    @ColumnInfo("seventh_direction") val seventhDirection: String,
    @ColumnInfo("eighth_direction") val eighthDirection: String,
    @ColumnInfo("ninth_direction") val ninthDirection: String,
    @ColumnInfo("tenth_direction") val tenthDirection: String,
    @ColumnInfo("recipe_id") val recipeId: Int
)
