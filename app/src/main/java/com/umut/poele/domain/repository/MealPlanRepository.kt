package com.umut.poele.domain.repository

import com.umut.poele.data.source.remote.dto.MealDto
import com.umut.poele.data.source.remote.response.Week

interface MealPlanRepository {

    suspend fun getMenuCardMealInfo(timeFrame: String, targetCalories: Int) : Week
}
