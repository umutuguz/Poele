package com.umut.poele.database.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.umut.poele.database.supply.Supply
import com.umut.poele.database.user.User

data class SupplyWithUsers(
    @Embedded val supply: Supply,
    @Relation(
        parentColumn = "supply_id",
        entityColumn = "user_id",
        associateBy = Junction(UserSupplyCrossRef::class)
    )
    val users: List<User>
)
