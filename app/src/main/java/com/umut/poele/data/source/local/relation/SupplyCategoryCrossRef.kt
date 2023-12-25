package com.umut.poele.data.source.local.relation

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["supply_id", "supply_category_title"])
class SupplyCategoryCrossRef(
    @ColumnInfo("supply_id") val supplyId: Int,
    @ColumnInfo("supply_category_title") val supplyCategoryTitle: String
)
