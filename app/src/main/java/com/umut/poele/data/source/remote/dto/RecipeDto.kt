package com.umut.poele.data.source.remote.dto

import com.squareup.moshi.Json
import com.umut.poele.domain.model.Macro
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.domain.model.Supply
import com.umut.poele.domain.model.toUnit
import com.umut.poele.util.Levels
import com.umut.poele.util.Units
import com.umut.poele.util.extension.toDifficultyLevel
import javax.crypto.Mac

fun RecipeDto.toRecipe(): RecipeBasic{
    return RecipeBasic(
        id ?: -1,
        title ?: "",
        image ?: "",
        sourceName ?: "",
        dishTypes ?: emptyList(),
        summary ?: "",
        prepTime = preparationMinutes ?: -1,
        servings = servings ?: -1,
        difficultyLevel = spoonacularScore?.toDifficultyLevel() ?: Levels.UNDETERMINED,
        cuisines ?: emptyList(),
        false,
        vegan ?: false,
        directions = summary?.split(Regex("(?<=\\.) ")) ?: emptyList(),
        ingredients = extendedIngredients?.toSupply() ?: emptyList(),
        macro = nutrition?.toMacro() ?: Macro()
    )
}

private fun List<ExtendedIngredient>.toSupply(): List<Supply> {
    val list = mutableListOf<Supply>()

    this.forEach {
        list.add(Supply(
            it.id ?: -1,
            it.name ?: "",
            "https://spoonacular.com/cdn/ingredients_100x100/${it.image}",
            it.aisle ?: "",
            it.amount ?: 0.0,
            it.unit?.toUnit() ?: Units.UNDETERMINED
        ))
    }
    return list
}

data class RecipeDto(
    @Json(name = "vegetarian")
    val vegetarian: Boolean?,
    @Json(name = "vegan")
    val vegan: Boolean?,
    @Json(name = "glutenFree")
    val glutenFree: Boolean?,
    @Json(name = "dairyFree")
    val dairyFree: Boolean?,
    @Json(name = "veryHealthy")
    val veryHealthy: Boolean?,
    @Json(name = "cheap")
    val cheap: Boolean?,
    @Json(name = "veryPopular")
    val veryPopular: Boolean?,
    @Json(name = "sustainable")
    val sustainable: Boolean?,
    @Json(name = "lowFodmap")
    val lowFodmap: Boolean?,
    @Json(name = "weightWatcherSmartPoints")
    val weightWatcherSmartPoints: Int?,
    @Json(name = "gaps")
    val gaps: String?,
    @Json(name = "preparationMinutes")
    val preparationMinutes: Int?,
    @Json(name = "cookingMinutes")
    val cookingMinutes: Int?,
    @Json(name = "aggregateLikes")
    val aggregateLikes: Int?,
    @Json(name = "healthScore")
    val healthScore: Int?,
    @Json(name = "creditsText")
    val creditsText: String?,
    @Json(name = "license", ignore = true)
    val license: String? = "",
    @Json(name = "sourceName")
    val sourceName: String?,
    @Json(name = "pricePerServing")
    val pricePerServing: Double?,
    @Json(name = "extendedIngredients")
    val extendedIngredients: List<ExtendedIngredient>?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "readyInMinutes")
    val readyInMinutes: Int?,
    @Json(name = "servings")
    val servings: Int?,
    @Json(name = "sourceUrl")
    val sourceUrl: String?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "imageType")
    val imageType: String?,
    @Json(name = "nutrition")
    val nutrition: Nutrition?,
    @Json(name = "summary")
    val summary: String?,
    @Json(name = "cuisines")
    val cuisines: List<String>?,
    @Json(name = "dishTypes")
    val dishTypes: List<String>?,
    @Json(name = "diets")
    val diets: List<Any>?,
    @Json(name = "occasions")
    val occasions: List<Any>?,
    @Json(name = "winePairing", ignore = true)
    val winePairing: WinePairing? = WinePairing(),
    @Json(name = "instructions")
    val instructions: String?,
    @Json(name = "analyzedInstructions")
    val analyzedInstructions: List<Any>?,
    @Json(name = "originalId")
    val originalId: Any?,
    @Json(name = "spoonacularScore")
    val spoonacularScore: Double?,
    @Json(name = "spoonacularSourceUrl")
    val spoonacularSourceUrl: String
)

data class ExtendedIngredient(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "aisle")
    val aisle: String?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "consistency")
    val consistency: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "nameClean")
    val nameClean: String?,
    @Json(name = "original")
    val original: String?,
    @Json(name = "originalName")
    val originalName: String?,
    @Json(name = "amount")
    val amount: Double?,
    @Json(name = "unit")
    val unit: String?,
    @Json(name = "meta")
    val meta: List<String>?,
    @Json(name = "measures")
    val measures: Measures?
)

data class Nutrition(
    @Json(name = "nutrients")
    val nutrients: List<Nutrient>?,
    @Json(name = "properties")
    val properties: List<Property>?,
    @Json(name = "flavonoids")
    val flavonoids: List<Flavonoid>?,
    @Json(name = "ingredients")
    val ingredients: List<Ingredient>?,
    @Json(name = "caloricBreakdown")
    val caloricBreakdown: CaloricBreakdown?,
    @Json(name = "weightPerServing")
    val weightPerServing: WeightPerServing?
)

data class WinePairing(
    @Json(name = "pairedWines")
    val pairedWines: List<Any> = emptyList(),
    @Json(name = "pairingText")
    val pairingText: String = "",
    @Json(name = "productMatches")
    val productMatches: List<Any> = emptyList()
)

data class Measures(
    @Json(name = "us")
    val us: Us?,
    @Json(name = "metric")
    val metric: Metric?
)

data class Us(
    @Json(name = "amount")
    val amount: Double?,
    @Json(name = "unitShort")
    val unitShort: String?,
    @Json(name = "unitLong")
    val unitLong: String?
)

data class Metric(
    @Json(name = "amount")
    val amount: Double?,
    @Json(name = "unitShort")
    val unitShort: String?,
    @Json(name = "unitLong")
    val unitLong: String?
)

fun Nutrition.toMacro() : Macro {
    val list = this.nutrients
    val macro = Macro()
    list?.forEach {
        when (it.name) {
            "Calories" -> macro.calorie = it.amount ?: -1.0
            "Fat" -> macro.fat = it.amount ?: -1.0
            "Carbohydrates" -> macro.carb = it.amount ?: -1.0
            "Protein" -> macro.protein = it.amount ?: -1.0
            "Fiber" -> macro.fiber = it.amount ?: -1.0
        }
    }
    return macro
}

data class Nutrient(
    @Json(name = "name")
    val name: String?,
    @Json(name = "amount")
    val amount: Double?,
    @Json(name = "unit")
    val unit: String?,
    @Json(name = "percentOfDailyNeeds")
    val percentOfDailyNeeds: Double?
)

data class Property(
    @Json(name = "name")
    val name: String?,
    @Json(name = "amount")
    val amount: Double?,
    @Json(name = "unit")
    val unit: String?
)

data class Flavonoid(
    @Json(name = "name")
    val name: String?,
    @Json(name = "amount")
    val amount: Double?,
    @Json(name = "unit")
    val unit: String?
)

data class Ingredient(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "amount")
    val amount: Double?,
    @Json(name = "unit")
    val unit: String?,
    @Json(name = "nutrients")
    val nutrients: List<Nutrient>?
)

data class CaloricBreakdown(
    @Json(name = "percentProtein")
    val percentProtein: Double?,
    @Json(name = "percentFat")
    val percentFat: Double?,
    @Json(name = "percentCarbs")
    val percentCarbs: Double?
)

data class WeightPerServing(
    @Json(name = "amount")
    val amount: Int?,
    @Json(name = "unit")
    val unit: String?
)
