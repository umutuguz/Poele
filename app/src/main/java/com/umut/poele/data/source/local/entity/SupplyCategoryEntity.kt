package com.umut.poele.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("supply_category")
data class SupplyCategoryEntity(
    @PrimaryKey @ColumnInfo("supply_category_title") val supplyCategoryTitle: String
)
