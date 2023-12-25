package com.umut.poele.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.umut.poele.data.source.local.entity.AddressEntity
import com.umut.poele.data.source.local.entity.UserEntity

data class UserWithAddresses(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "user_id"
    )
    val addresses: List<AddressEntity>
)
