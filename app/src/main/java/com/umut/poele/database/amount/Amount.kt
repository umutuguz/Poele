package com.umut.poele.database.amount

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class Amount(
    @PrimaryKey @ColumnInfo("amount_id") val amountId: Int,
    @ColumnInfo("amount") val amount: Double,
    @ColumnInfo("unit") val unit: String,
    @ColumnInfo("state") val state: String,
    @ColumnInfo("date") val date: String,
    @ColumnInfo("recipe_id") val recipeId: Int,
    @ColumnInfo("user_id") val userId: Int,
    @ColumnInfo("supply_id") val supplyId: Int,
)
