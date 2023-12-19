package com.umut.poele.database.category

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("supply_category")
data class SupplyCategory(
    @PrimaryKey @ColumnInfo("supply_category_title") val supplyCategoryTitle: String
)
