package com.umut.poele.database.menu

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface MenuCardDao {

    @Query("SELECT * FROM menu_card LIMIT 4")
    fun getAll(): Flow<List<MenuCard>>

    @Upsert
    suspend fun upsertMenuCard(menuCard: MenuCard)
}
