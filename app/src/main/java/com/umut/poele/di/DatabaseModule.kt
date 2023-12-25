package com.umut.poele.di

import android.content.Context
import com.umut.poele.data.source.local.AppDatabase
import com.umut.poele.data.source.local.dao.RecipeDao
import com.umut.poele.data.source.local.dao.SupplyDao
import com.umut.poele.data.source.local.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }

    @Provides
    fun provideRecipeDao(appDatabase: AppDatabase): RecipeDao {
        return appDatabase.recipeDao()
    }

    @Provides
    fun provideSupplyDao(appDatabase: AppDatabase): SupplyDao {
        return appDatabase.supplyDao()
    }

}
