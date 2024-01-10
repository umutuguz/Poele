package com.umut.poele.util.extension

import com.umut.poele.data.source.remote.dto.Nutrition
import com.umut.poele.data.source.remote.dto.RecipeBasicDto
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.util.Levels

fun RecipeBasicDto.toRecipeBasic(): RecipeBasic  {
    return RecipeBasic(
        id ?: -1,
        title ?: "",
        image ?: "",
        sourceName ?: "",
        prepTime = preparationMinutes ?: -1,
        servings = servings ?: -1,
        difficultyLevel = spoonacularScore?.toDifficultyLevel() ?: Levels.UNDETERMINED
    )
}

fun Number.toDifficultyLevel(): Levels {
    val easy = 75.0..100.0
    val intermediate = 50.0..75.0
    val hard = 0.0..50.0
    return when (this as Double) {
        in easy -> {
            Levels.EASY
        }

        in intermediate -> {
            Levels.INTERMEDIATE
        }

        in hard -> {
            Levels.HARD
        }

        else -> {
            Levels.UNDETERMINED
        }
    }
}
