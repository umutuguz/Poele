package com.umut.poele.ui.recipe_detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.umut.poele.domain.model.Equipment
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.domain.use_case.GetRecipesUseCase
import com.umut.poele.domain.use_case.GetSuppliesUseCase
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.ShopListListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeRecipeDetailViewModel @Inject constructor(
    private val getRecipesUseCase: GetRecipesUseCase, private val getSuppliesUseCase: GetSuppliesUseCase
) : BaseViewModel(), ShopListListener {

    private val _recipeInfoLiveData = MutableLiveData<RecipeBasic>()
    val recipeInfoLiveData get() = _recipeInfoLiveData
    private val _recipeEquipmentLiveData = MutableLiveData<List<Equipment>>()
    val recipeEquipmentLiveData get() = _recipeEquipmentLiveData

    fun navigateUp() {
        navigateBack()
    }

    override fun onShopListClicked() {
        navigate(HomeRecipeDetailFragmentDirections.actionHomeRecipeDetailFragmentToShopListFragment())
    }

    fun getRecipeInfo(clickedRecipeId: Int, includeNutrition: Boolean) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                getRecipesUseCase.getRecipeInfo(clickedRecipeId, includeNutrition)
            }
            result.data?.let {
                _recipeInfoLiveData.value = it
            }
        }
    }

    fun getEquipment(clickedRecipeId: Int) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) { getRecipesUseCase.getEquipmentWithId(clickedRecipeId) }
            result.data?.let {
                _recipeEquipmentLiveData.value = it
            }
        }
    }

    fun increaseServings(clickedRecipe: RecipeBasic) {
        val servings = clickedRecipe.servings
        val supplyList = clickedRecipe.ingredients

        supplyList.forEach {
            Log.i("umutcan", "amount: ${it.amount}")
            it.amount = (servings + 1) * it.amount / servings
            Log.i("umutcan", "increased amount: ${it.amount}")
        }

        viewModelScope.launch {
            if (servings < 15) {
                _recipeInfoLiveData.value = clickedRecipe.copy(servings = servings + 1, ingredients = supplyList)
            }
        }
    }

    fun decreaseServings(clickedRecipe: RecipeBasic) {
        Log.i("umutcan", "decrease clickedRecipe: ${clickedRecipe.ingredients}")
        Log.i("umutcan", "decrease clickedRecipe servings: ${clickedRecipe.servings}")
        val servings = clickedRecipe.servings
        val supplyList = clickedRecipe.ingredients
        if (servings > 1) {
            supplyList.forEach {
                it.amount = (servings - 1) * it.amount / servings
            }
        }
        viewModelScope.launch {
            if (servings > 1) {
                _recipeInfoLiveData.value = clickedRecipe.copy(servings = servings - 1, ingredients = supplyList)
            }
        }
    }

    fun addShopList(clickedRecipe: RecipeBasic) {
        viewModelScope.launch {
            getRecipesUseCase.upsertRecipeToShopList(clickedRecipe)
        }
    }

    fun addShopListSupply(clickedRecipe: RecipeBasic) {
        viewModelScope.launch {
            clickedRecipe.ingredients.forEach {
                getSuppliesUseCase.upsertSupplyToShopListSupply(it)
            }
        }
    }

}
