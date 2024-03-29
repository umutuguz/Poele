package com.umut.poele.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.umut.poele.domain.model.ImageUrl
import com.umut.poele.domain.model.Supply

fun SupplyEntity.toSupply(userId: Int = -1) : Supply {
    return Supply(
        supplyId,
        title,
        averageGML = averageGMl,
        userId = userId
    )
}

@Entity(tableName = "supply")
class SupplyEntity(
    @PrimaryKey @ColumnInfo("supply_id") val supplyId: Int,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("image_url") val imageUrl: ImageUrl,
    @ColumnInfo("average_g_ml") val averageGMl: Int
)
