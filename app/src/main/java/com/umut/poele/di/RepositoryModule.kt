package com.umut.poele.di

import com.umut.poele.data.repository.RecipeRepositoryImpl
import com.umut.poele.data.source.remote.PoeleApiService
import com.umut.poele.data.source.local.dao.RecipeDao
import com.umut.poele.data.source.local.dao.UserDao
import com.umut.poele.domain.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepositoryImpl(poeleApiService: PoeleApiService, recipeDao: RecipeDao, userDao: UserDao): RecipeRepository {
        return RecipeRepositoryImpl(poeleApiService, recipeDao, userDao)
    }
}
