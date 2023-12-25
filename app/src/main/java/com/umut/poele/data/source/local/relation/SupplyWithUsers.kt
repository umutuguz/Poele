package com.umut.poele.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.data.source.local.entity.SupplyEntity
import com.umut.poele.data.source.local.entity.UserEntity

data class SupplyWithUsers(
    @Embedded val supply: SupplyEntity,
    @Relation(
        parentColumn = "supply_id",
        entityColumn = "user_id",
        associateBy = Junction(UserSupplyCrossRef::class)
    )
    val users: List<UserEntity>
)
