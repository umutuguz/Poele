package com.umut.poele.database.equipment

import androidx.room.Dao
import androidx.room.Upsert
import com.umut.poele.database.cuisine.Cuisine

@Dao
interface EquipmentDao {

    @Upsert
    suspend fun upsertEquipment(equipment: Equipment)
}
