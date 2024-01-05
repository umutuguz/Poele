package com.umut.poele.domain.repository

import com.umut.poele.data.source.local.entity.ShopListEntity
import com.umut.poele.data.source.remote.dto.EquipmentDto
import com.umut.poele.data.source.remote.dto.RecipeBasicDto
import com.umut.poele.data.source.remote.dto.RecipeDto
import com.umut.poele.domain.model.RecipeBasic

interface RecipeRepository {

    suspend fun getRecipes(number: Int): List<RecipeBasicDto>
    suspend fun getRecipeInfo(id: Int, includeNutrition: Boolean): RecipeDto
    suspend fun getRecipeWithType(info: Boolean,type: String, number: Int): List<RecipeBasicDto>

    suspend fun getEquipmentWithId(id: Int): List<EquipmentDto>

    suspend fun getShopList(): List<ShopListEntity>

    suspend fun upsertShopList(shopListEntity: ShopListEntity)

    suspend fun deleteAllRecipesFromShopList() : Boolean
}
