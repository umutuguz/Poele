package com.umut.poele.domain.use_case

import android.util.Log
import com.umut.poele.data.source.remote.response.toList
import com.umut.poele.domain.model.MenuCard
import com.umut.poele.domain.repository.MealPlanRepository
import com.umut.poele.util.Meals
import com.umut.poele.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class GetMenuCardUseCase @Inject constructor(private val mealPlanRepository: MealPlanRepository) {

    suspend fun getMenuCard(userName: String,timeFrame: String, targetCalories: Int): Resource<List<MenuCard>> {
        val menuCard = mutableListOf<MenuCard>()
        val list = mutableListOf<String>()
        val mealType = listOf(Meals.BREAKFAST, Meals.BRUNCH, Meals.LUNCH, Meals.DINNER)
        withContext(Dispatchers.IO) {
            try {
                mealPlanRepository.getMenuCardMealInfo(timeFrame, targetCalories).toList().forEachIndexed { index, element ->
                    element.forEach {
                        list.add(it.title)
                    }
                    menuCard.add(MenuCard(mealType[index], userName, primaryMealName = list[index*3], secondaryMealName = list[index*3+1],
                        tertiaryMealName =
                    list[index*3+2]))
                }
            } catch (e: retrofit2.HttpException) {
                Log.e("HttpException", e.localizedMessage ?: "Http Error occurred")
            } catch (e: IOException) {
                Log.e("IOException", e.localizedMessage ?: "IO Error occured")
            }
        }
        return Resource.Success(menuCard)
    }
}
