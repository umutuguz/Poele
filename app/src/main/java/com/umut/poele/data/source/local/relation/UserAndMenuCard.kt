package com.umut.poele.data.source.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.umut.poele.data.source.local.entity.MenuCardEntity
import com.umut.poele.data.source.local.entity.UserEntity

data class UserAndMenuCard(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "user_id"
    )
    val menuCard: MenuCardEntity
)
