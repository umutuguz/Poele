package com.umut.poele.database.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.umut.poele.database.menu.MenuCard
import com.umut.poele.database.user.User

data class UserAndMenuCard(
    @Embedded val user: User,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "user_id"
    )
    val menuCard: MenuCard
)
