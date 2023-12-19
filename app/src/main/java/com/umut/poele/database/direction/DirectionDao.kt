package com.umut.poele.database.direction

import androidx.room.Dao
import androidx.room.Upsert
import com.umut.poele.database.cuisine.Cuisine

@Dao
interface DirectionDao {

    @Upsert
    suspend fun upsertDirection(direction: Direction)
}
