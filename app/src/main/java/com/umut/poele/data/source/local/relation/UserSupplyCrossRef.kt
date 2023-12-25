package com.umut.poele.data.source.local.relation

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["user_id", "supply_id"])
class UserSupplyCrossRef(
    @ColumnInfo("user_id")val userId: Int,
    @ColumnInfo("supply_id")val supplyId: Int
)
