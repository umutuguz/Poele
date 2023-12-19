package com.umut.poele.database.supply

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.umut.poele.model.ImageUrl

@Entity
class Supply(
    @PrimaryKey @ColumnInfo("supply_id") val supplyId: Int,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("image_url") val imageUrl: ImageUrl,
    @ColumnInfo("average_g_ml") val averageGMl: Int
)
