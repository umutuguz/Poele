package com.umut.poele.util.extension

import com.umut.poele.data.source.remote.dto.RecipeBasicDto
import com.umut.poele.domain.model.RecipeBasic

fun RecipeBasicDto.toRecipeBasic() : RecipeBasic {
    val recipeModel = RecipeBasic()
    return RecipeBasic(
        id,
        title,
        image,
    )
}
