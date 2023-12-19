package com.umut.poele.database.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.umut.poele.database.macro.Macro
import com.umut.poele.database.supply.Supply

data class SupplyAndMacro(
    @Embedded val supply: Supply,
    @Relation(
        parentColumn = "supply_id",
        entityColumn = "macro_id"
    )
    val macro: Macro
)
