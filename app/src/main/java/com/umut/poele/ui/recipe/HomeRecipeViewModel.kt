package com.umut.poele.ui.recipe

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.umut.poele.data.source.local.dao.RecipeDao
import com.umut.poele.data.source.local.relation.RecipeCategoryWithRecipes
import com.umut.poele.data.source.local.relation.UserWithRecipeCategoriesWithRecipes
import com.umut.poele.data.source.local.relation.UserWithRecipes
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.domain.use_case.GetRecipesUseCase
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.FilterListener
import com.umut.poele.util.MealTypes
import com.umut.poele.util.RecipeListener
import com.umut.poele.util.SearchBarListener
import com.umut.poele.util.ShopListListener
import com.umut.poele.util.toMealCategoryList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeRecipeViewModel @Inject constructor(
    private val getRecipesUseCase: GetRecipesUseCase
) : BaseViewModel(), RecipeListener, SearchBarListener, FilterListener, ShopListListener {

    private val allRecipeList = MutableList(MealTypes.MAINCOURSE.toMealCategoryList().size) {
        listOf(RecipeBasic())
    }
    private val _allRecipeListLiveData = MutableLiveData<List<List<RecipeBasic>>>()
    val allRecipeListLiveData get() = _allRecipeListLiveData
    val recipeCategoryList = MealTypes.MAINCOURSE.toMealCategoryList()

    fun onBackClicked() {
        navigateBack()
    }

    override fun onRecipeClicked(clickedRecipe: RecipeBasic) {
        navigate(HomeRecipeFragmentDirections.actionHomeRecipeFragmentToHomeRecipeDetailFragment(clickedRecipe))
    }

    override fun onSearchBarClicked() {
        navigate(HomeRecipeFragmentDirections.actionHomeRecipeFragmentToSearchFragment())
    }

    override fun onFilterClicked() {
        navigate(HomeRecipeFragmentDirections.actionHomeRecipeFragmentToFilterDialog(), true)
    }

    override fun onShopListClicked() {
        navigate(HomeRecipeFragmentDirections.actionHomeRecipeFragmentToShopListFragment())
    }

    init {
        getAllCategoryRecipes()
    }

    private fun getAllCategoryRecipes() {
        var index = 0

        recipeCategoryList.forEach {
            getRecipesWithType(it.title, index)
            ++index
        }
    }

    private fun getRecipesWithType(type: String, index: Int) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                getRecipesUseCase.getRecipesWithType(true, type.lowercase(), 15)
            }
            result.data?.let {
                allRecipeList.set(index, it)
            }
            if (allRecipeList.size == recipeCategoryList.size) {
                _allRecipeListLiveData.value = allRecipeList
            }
        }
    }

}
