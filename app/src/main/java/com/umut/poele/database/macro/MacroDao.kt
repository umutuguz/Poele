package com.umut.poele.database.macro

import androidx.room.Dao
import androidx.room.Upsert

@Dao
interface MacroDao {

    @Upsert
    suspend fun upsertMacro(macro: Macro)
}
