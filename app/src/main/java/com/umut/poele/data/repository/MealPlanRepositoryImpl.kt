package com.umut.poele.data.repository

import com.umut.poele.data.source.remote.PoeleApiService
import com.umut.poele.data.source.remote.dto.MealDto
import com.umut.poele.data.source.remote.response.Monday
import com.umut.poele.data.source.remote.response.Week
import com.umut.poele.domain.repository.MealPlanRepository

class MealPlanRepositoryImpl(private val api: PoeleApiService) : MealPlanRepository {

    override suspend fun getMenuCardMealInfo(timeFrame: String, targetCalories: Int): Week {
        return  api.getMenuCard(timeFrame, targetCalories).week
    }
}
