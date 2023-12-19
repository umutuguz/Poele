package com.umut.poele.database.user

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.umut.poele.database.menu.MenuCard
import com.umut.poele.database.relation.UserRecipeCrossRef
import com.umut.poele.database.relation.UserSupplyCrossRef
import com.umut.poele.database.relation.UserWithAddresses
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE user_id = :userId")
    fun getUserWithUserId(userId: Int): Flow<User>

    @Query("SELECT * FROM user ORDER BY user_id ASC")
    fun getAllUsers(): Flow<List<User>>

    @Query("SELECT * FROM user WHERE email = :userEmail")
    fun getUserWithUserEmail(userEmail: String): Flow<List<User>>

    @Transaction
    @Query("SELECT * FROM menu_card WHERE user_id = :userId")
    fun getMenuCardWithUserId(userId: Int): Flow<List<MenuCard>>

    @Transaction
    @Query("SELECT * FROM user WHERE user_id = :userId")
    fun getAddressesWithUserId(userId: Int): Flow<List<UserWithAddresses>>

    @Upsert
    suspend fun upsertUser(user: User)

    @Upsert
    suspend fun upsertUserSupplyCrossRef(crossRef: UserSupplyCrossRef)

    @Upsert
    suspend fun upsertUserRecipeCrossRef(crossRef: UserRecipeCrossRef)
}
