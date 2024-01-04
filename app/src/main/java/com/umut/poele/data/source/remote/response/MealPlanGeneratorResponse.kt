package com.umut.poele.data.source.remote.response

import com.squareup.moshi.Json
import com.umut.poele.data.source.remote.dto.MealDto
import com.umut.poele.data.source.remote.dto.NutrientDto

fun Week.toList(): List<List<MealDto>>{
    val mealInfoMonday = monday.meals
    val mealInfoTuesday = tuesday.meals
    val mealInfoWednesday = wednesday.meals
    val mealInfoThursday = thursday.meals
    return listOf<List<MealDto>>(mealInfoMonday, mealInfoTuesday, mealInfoWednesday, mealInfoThursday)
}

data class MealPlannerResponse(
    @Json(name = "week")
    val week: Week
)

data class Week(
    @Json(name = "monday")
    val monday: Monday,
    @Json(name = "tuesday")
    val tuesday: Tuesday,
    @Json(name = "wednesday")
    val wednesday: Wednesday,
    @Json(name = "thursday")
    val thursday: Thursday,
    @Json(name = "friday")
    val friday: Friday,
    @Json(name = "saturday")
    val saturday: Saturday,
    @Json(name = "sunday")
    val sunday: Sunday
)

data class Monday(
    @Json(name = "meals")
    val meals: List<MealDto>,
    @Json(name = "nutrients")
    val nutrients: NutrientDto
)

data class Tuesday(
    @Json(name = "meals")
    val meals: List<MealDto>,
    @Json(name = "nutrients")
    val nutrients: NutrientDto
)

data class Wednesday(
    @Json(name = "meals")
    val meals: List<MealDto>,
    @Json(name = "nutrients")
    val nutrients: NutrientDto
)

data class Thursday(
    @Json(name = "meals")
    val meals: List<MealDto>,
    @Json(name = "nutrients")
    val nutrients: NutrientDto
)

data class Friday(
    @Json(name = "meals")
    val meals: List<MealDto>,
    @Json(name = "nutrients")
    val nutrients: NutrientDto
)

data class Saturday(
    @Json(name = "meals")
    val meals: List<MealDto>,
    @Json(name = "nutrients")
    val nutrients: NutrientDto
)

data class Sunday(
    @Json(name = "meals")
    val meals: List<MealDto>,
    @Json(name = "nutrients")
    val nutrients: NutrientDto
)
