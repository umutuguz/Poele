package com.umut.poele.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.umut.poele.data.source.local.entity.MacroEntity
import com.umut.poele.data.source.local.entity.SupplyEntity

data class SupplyAndMacro(
    @Embedded val supply: SupplyEntity,
    @Relation(
        parentColumn = "supply_id",
        entityColumn = "macro_id"
    )
    val macro: MacroEntity
)
