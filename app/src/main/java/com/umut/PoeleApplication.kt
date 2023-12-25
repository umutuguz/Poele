package com.umut

import android.app.Application
import com.umut.poele.data.source.local.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PoeleApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}
