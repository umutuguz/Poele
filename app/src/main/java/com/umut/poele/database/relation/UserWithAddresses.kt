package com.umut.poele.database.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.umut.poele.database.address.Address
import com.umut.poele.database.user.User

data class UserWithAddresses(
    @Embedded val user: User,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "user_id"
    )
    val addresses: List<Address>
)
