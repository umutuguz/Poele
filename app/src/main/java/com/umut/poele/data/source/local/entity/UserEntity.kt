package com.umut.poele.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.umut.poele.domain.model.User

@Entity(primaryKeys = ["user_id", "email"], tableName = "user")
data class UserEntity(
    @ColumnInfo("user_id") val id: Int,
    @ColumnInfo("email") val email: String,
    @ColumnInfo("password") val password: String,
    @ColumnInfo("first_name") val firstName: String,
    @ColumnInfo("last_name") val lastName: String,
    @ColumnInfo("phone") val phone: String,
)

fun UserEntity.toUser(): User {
    return User(
        id = id,
        email,
        firstName = firstName,
        lastName = lastName,
        phone = phone
    )
}
