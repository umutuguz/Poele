package com.umut.poele.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.data.source.local.entity.SupplyEntity
import com.umut.poele.data.source.local.entity.UserEntity

data class UserWithSupplies(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = "userId",
        entityColumn = "supplyId",
        associateBy = Junction(UserSupplyCrossRef::class)
    )
    val supplies: List<SupplyEntity>
)
