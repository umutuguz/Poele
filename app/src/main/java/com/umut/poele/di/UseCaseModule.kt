package com.umut.poele.di

import androidx.room.PrimaryKey
import com.umut.poele.domain.repository.RecipeRepository
import com.umut.poele.domain.use_case.GetRecipes
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
    fun provideGetRecipesUseCase(recipeRepository: RecipeRepository): GetRecipes {
        return GetRecipes()
    }
}
