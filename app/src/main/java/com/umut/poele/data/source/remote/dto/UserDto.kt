package com.umut.poele.data.source.remote.dto

import com.umut.poele.domain.model.User

//fun UserDto.toUser(): User {
//    return User(
//        id = id.toInt(), email = email, firstName = firstName, lastName = lastName, profilePhotoUrl = image
//    )

//}

data class UserDto(
    val id: String,
)
