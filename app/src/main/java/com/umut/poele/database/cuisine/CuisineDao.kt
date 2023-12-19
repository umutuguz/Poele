package com.umut.poele.database.cuisine

import androidx.room.Dao
import androidx.room.Upsert

@Dao
interface CuisineDao {

    @Upsert
    suspend fun upsertCuisine(cuisine: Cuisine)
}
