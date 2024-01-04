package com.umut.poele.domain.model

import com.umut.poele.R
import com.umut.poele.util.Levels
import com.umut.poele.util.States
import com.umut.poele.util.Units
import java.time.LocalDate

class RecipeDataSource {

    fun loadRecipe(): List<RecipeBasic> {
        return listOf(
            RecipeBasic(),
            RecipeBasic(),
            RecipeBasic(),
            RecipeBasic(),
            RecipeBasic()
        )

    }

}
