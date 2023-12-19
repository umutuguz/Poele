package com.umut.poele.database.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(primaryKeys = ["user_id", "email"])
data class User(
    @ColumnInfo("user_id") val id: Int,
    @ColumnInfo("email") val email: String,
    @ColumnInfo("password") val password: String,
    @ColumnInfo("first_name") val firstName: String,
    @ColumnInfo("last_name") val lastName: String,
    @ColumnInfo("phone") val phone: String,
)
