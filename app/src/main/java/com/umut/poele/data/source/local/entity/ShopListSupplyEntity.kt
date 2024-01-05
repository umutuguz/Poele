package com.umut.poele.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.umut.poele.domain.model.Supply
import com.umut.poele.domain.model.toUnit

@Entity(tableName = "shoplist_supply")
data class ShopListSupplyEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("supply_title")
    val supplyTitle: String,
    @ColumnInfo("image_url")
    val imageUrl: String,
    @ColumnInfo("amount")
    val amount: Double,
    @ColumnInfo("unit")
    val unit: String
)

fun ShopListSupplyEntity.toSupply() :Supply {
    return Supply(
        id,
        supplyTitle,
        imageUrl,
        amount = amount,
        unit = unit.toUnit()
    )
}
