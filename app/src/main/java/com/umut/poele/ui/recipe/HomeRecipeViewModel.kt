package com.umut.poele.ui.recipe

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.umut.poele.database.recipe.Recipe
import com.umut.poele.database.recipe.RecipeDao
import com.umut.poele.database.relation.RecipeCategoryWithRecipes
import com.umut.poele.database.relation.UserWithRecipes
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.FilterListener
import com.umut.poele.util.RecipeDatabaseListener
import com.umut.poele.util.SearchBarListener
import com.umut.poele.util.ShopListListener
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeRecipeViewModel(
    private val recipeDao: RecipeDao
) : BaseViewModel(), RecipeDatabaseListener, SearchBarListener, FilterListener, ShopListListener {

    private var _recipeCategoryListLiveData: MutableLiveData<List<RecipeCategoryWithRecipes>> = MutableLiveData()
    val recipeCategoryListLiveData get() = _recipeCategoryListLiveData

    init {
        getAllRecipeCategories()
    }

    private fun getAllRecipeCategories() {
        val recipeList = mutableListOf<RecipeCategoryWithRecipes>()

        viewModelScope.launch {
            recipeDao.getAllRecipeCategories().collect { list ->
                Log.i("umutcan", "list: ${list.size}")

                list.map {recipeCategory->
                    async { getRecipesWithCategory(recipeCategory.recipeCategoryTitle).collect {
                        recipeList.add(it)
                    } }

                }.map {
                    it.await()
                }
            }
        }
        _recipeCategoryListLiveData.postValue(recipeList)
    }


    fun getAllRecipesWithUserId(userId: Int): LiveData<UserWithRecipes> = recipeDao.getAllRecipesOfUser(userId).asLiveData()

    private fun getRecipesWithCategory(recipeCategoryTitle: String): Flow<RecipeCategoryWithRecipes> =
        recipeDao.getRecipesWithCategory(recipeCategoryTitle)

    fun onBackClicked() {
        navigateBack()
    }

    override fun onRecipeClicked(clickedRecipe: Recipe) {
        navigate(HomeRecipeFragmentDirections.actionHomeRecipeFragmentToHomeRecipeDetailFragment())
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
}

class HomeRecipeViewModelFactory(
    private val recipeDao: RecipeDao,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeRecipeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return HomeRecipeViewModel(recipeDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
