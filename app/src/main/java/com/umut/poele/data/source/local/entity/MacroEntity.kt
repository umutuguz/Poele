package com.umut.poele.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("macro")
data class MacroEntity(
    @PrimaryKey @ColumnInfo("macro_id") val macroId: Int,
    @ColumnInfo("fat") val fat: Double,
    @ColumnInfo("carb") val carb: Double,
    @ColumnInfo("fiber") val fiber: Double,
    @ColumnInfo("protein") val protein: Double,
    @ColumnInfo("calorie") val calorie: Double,
    @ColumnInfo("supply_id") val supplyId: Int
)
