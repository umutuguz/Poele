package com.umut.poele.database.equipment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Equipment(
     @PrimaryKey @ColumnInfo("equipment_title") val equipmentTitle: String
)
