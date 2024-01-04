package com.umut.poele.di

import com.umut.poele.data.source.local.dao.RecipeDao
import com.umut.poele.domain.repository.MealPlanRepository
import com.umut.poele.domain.repository.RecipeRepository
import com.umut.poele.domain.repository.SupplyRepository
import com.umut.poele.domain.use_case.GetMenuCardUseCase
import com.umut.poele.domain.use_case.GetRecipesUseCase
import com.umut.poele.domain.use_case.GetSuppliesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetRecipesUseCase(recipeRepository: RecipeRepository, recipeDao: RecipeDao): GetRecipesUseCase {
        return GetRecipesUseCase(recipeRepository, recipeDao)
    }
    @Singleton
    @Provides
    fun provideGetSuppliesUseCase(supplyRepository: SupplyRepository): GetSuppliesUseCase {
        return GetSuppliesUseCase(supplyRepository)
    }
    @Singleton
    @Provides
    fun provideGetMenuCardUseCase(mealPlanRepository: MealPlanRepository): GetMenuCardUseCase {
        return GetMenuCardUseCase(mealPlanRepository)
    }
}
