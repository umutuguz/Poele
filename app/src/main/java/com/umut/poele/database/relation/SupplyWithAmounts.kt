package com.umut.poele.database.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.umut.poele.database.amount.Amount
import com.umut.poele.database.supply.Supply

data class SupplyWithAmounts(
    @Embedded val supply: Supply,
    @Relation(
        parentColumn = "supply_id",
        entityColumn = "amount_id"
    )
    val amounts: List<Amount>
)
