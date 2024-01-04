package com.umut.poele.di

import com.umut.poele.data.repository.MealPlanRepositoryImpl
import com.umut.poele.data.repository.RecipeRepositoryImpl
import com.umut.poele.data.repository.SupplyRepositoryImpl
import com.umut.poele.data.source.local.dao.RecipeDao
import com.umut.poele.data.source.remote.PoeleApiService
import com.umut.poele.data.source.local.dao.SupplyDao
import com.umut.poele.domain.repository.MealPlanRepository
import com.umut.poele.domain.repository.RecipeRepository
import com.umut.poele.domain.repository.SupplyRepository
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
    fun provideRecipeRepositoryImpl(poeleApiService: PoeleApiService, recipeDao: RecipeDao): RecipeRepository {
        return RecipeRepositoryImpl(poeleApiService, recipeDao)
    }

    @Singleton
    @Provides
    fun provideMealPlanRepositoryImpl(api: PoeleApiService): MealPlanRepository {
        return MealPlanRepositoryImpl(api)
    }
    @Singleton
    @Provides
    fun provideSupplyRepositoryImpl(dao: SupplyDao): SupplyRepository {
        return SupplyRepositoryImpl(dao)
    }
}
