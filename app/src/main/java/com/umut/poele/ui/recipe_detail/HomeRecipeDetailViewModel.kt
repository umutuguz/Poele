package com.umut.poele.ui.recipe_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.umut.poele.domain.model.Equipment
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.domain.use_case.GetRecipesUseCase
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.ShopListListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeRecipeDetailViewModel @Inject constructor(private val getRecipesUseCase: GetRecipesUseCase)
    : BaseViewModel(), ShopListListener {

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

    fun getRecipeInfo(clickedRecipeId: Int, includeNutrition: Boolean){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                getRecipesUseCase.getRecipeInfo(clickedRecipeId, includeNutrition)
            }
            result.data?.let {
                _recipeInfoLiveData.value = it
            }
        }
    }

    fun getEquipment(clickedRecipeId: Int){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) { getRecipesUseCase.getEquipmentWithId(clickedRecipeId)}
            result.data?.let {
                _recipeEquipmentLiveData.value = it
            }
        }
    }

    fun increaseServings(clickedRecipe: RecipeBasic) {
        val servings = clickedRecipe.servings
        val supplyList = clickedRecipe.ingredients
        supplyList.forEach {
            it.amount = (servings + 1) / (servings) * it.amount
        }
        viewModelScope.launch{
            _recipeInfoLiveData.value = clickedRecipe.copy(servings = servings + 1, ingredients = supplyList)
        }
    }

    fun addShopList(clickedRecipe: RecipeBasic) {
        viewModelScope.launch{
            getRecipesUseCase.upsertRecipeToShopList(clickedRecipe)
        }
    }

}
