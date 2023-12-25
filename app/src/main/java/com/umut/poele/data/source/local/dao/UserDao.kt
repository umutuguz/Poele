package com.umut.poele.data.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.umut.poele.data.source.local.entity.AddressEntity
import com.umut.poele.data.source.local.entity.UserEntity
import com.umut.poele.data.source.local.entity.MenuCardEntity
import com.umut.poele.data.source.local.relation.UserRecipeCrossRef
import com.umut.poele.data.source.local.relation.UserSupplyCrossRef
import com.umut.poele.data.source.local.relation.UserWithAddresses
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE user_id = :userId")
    fun getUserWithUserId(userId: Int): Flow<UserEntity>

    @Query("SELECT * FROM user ORDER BY user_id ASC")
    fun getAllUsers(): Flow<List<UserEntity>>

    @Query("SELECT * FROM user WHERE email = :userEmail")
    fun getUserWithUserEmail(userEmail: String): Flow<List<UserEntity>>

    @Transaction
    @Query("SELECT * FROM menu_card WHERE user_id = :userId")
    fun getMenuCardWithUserId(userId: Int): Flow<List<MenuCardEntity>>

    @Transaction
    @Query("SELECT * FROM user WHERE user_id = :userId")
    fun getAddressesWithUserId(userId: Int): Flow<List<UserWithAddresses>>

    @Upsert
    suspend fun upsertUser(user: UserEntity)

    @Upsert
    suspend fun upsertUserSupplyCrossRef(crossRef: UserSupplyCrossRef)

    @Upsert
    suspend fun upsertUserRecipeCrossRef(crossRef: UserRecipeCrossRef)


    @Query("SELECT * FROM address ORDER BY title ASC")
    fun getAllAddresses(): List<AddressEntity>

    @Upsert
    suspend fun upsertAddress(address: AddressEntity)
    @Query("SELECT * FROM menu_card LIMIT 4")
    fun getAllMenuCards(): Flow<List<MenuCardEntity>>

    @Upsert
    suspend fun upsertMenuCard(menuCard: MenuCardEntity)
}
