package com.umut.poele.data.repository

import com.umut.poele.data.source.local.dao.RecipeDao
import com.umut.poele.data.source.local.entity.ShopListEntity
import com.umut.poele.data.source.remote.PoeleApiService
import com.umut.poele.data.source.remote.dto.EquipmentDto
import com.umut.poele.data.source.remote.dto.RecipeDto
import com.umut.poele.data.source.remote.dto.RecipeBasicDto
import com.umut.poele.domain.repository.RecipeRepository

class RecipeRepositoryImpl(private val api: PoeleApiService, private val recipeDao: RecipeDao) : RecipeRepository {

    override suspend fun getRecipes(number: Int): List<RecipeBasicDto> {
        val result = api.getRecipes(number)
        return if (result.totalResults != 0) {
            result.results
        }
        else {
            emptyList()
        }
    }

    override suspend fun getRecipeInfo(id: Int, includeNutrition: Boolean): RecipeDto {
        return api.getRecipeInfo(id, includeNutrition)
    }

    override suspend fun getRecipeWithType(info: Boolean,type: String, number: Int): List<RecipeBasicDto> {
        val result = api.getRecipeWithType(info, type, number)
        return if (result.totalResults != 0) {
            result.results
        }
        else {
            emptyList()
        }
    }

    override suspend fun getEquipmentWithId(id: Int): List<EquipmentDto> {
        val result = api.getEquipment(id)
        return if (result.equipment.isNotEmpty()) {
            result.equipment
        }
        else {
            emptyList()
        }
    }

    override suspend fun getShopList(): List<ShopListEntity> {
        val result = recipeDao.getShopList()
        return if (result.isNotEmpty()) {
            result
        } else {
            emptyList()
        }
    }
}
