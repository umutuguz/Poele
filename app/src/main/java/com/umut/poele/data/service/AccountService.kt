package com.umut.poele.data.service

import com.umut.poele.data.source.remote.dto.UserDto
import kotlinx.coroutines.flow.Flow

interface AccountService {
    val currentUser: Flow<UserDto?>
    val currentUserId: String
    fun hasUser(): Boolean
    suspend fun signIn(email: String, password: String)
    suspend fun signUp(email: String, password: String)
    suspend fun signOut()
    suspend fun deleteAccount()
}
