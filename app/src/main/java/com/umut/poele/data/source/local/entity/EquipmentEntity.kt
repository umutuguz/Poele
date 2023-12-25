package com.umut.poele.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "equipment")
data class EquipmentEntity(
     @PrimaryKey @ColumnInfo("equipment_title") val equipmentTitle: String
)
