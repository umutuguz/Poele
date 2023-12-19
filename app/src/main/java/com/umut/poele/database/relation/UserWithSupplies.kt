package com.umut.poele.database.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.database.supply.Supply
import com.umut.poele.database.user.User

data class UserWithSupplies(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "supplyId",
        associateBy = Junction(UserSupplyCrossRef::class)
    )
    val supplies: List<Supply>
)
