package com.umut.poele.ui.recipe

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.umut.poele.data.source.local.entity.RecipeEntity
import com.umut.poele.data.source.local.dao.RecipeDao
import com.umut.poele.data.source.local.entity.RecipeCategoryEntity
import com.umut.poele.data.source.local.relation.RecipeCategoryWithRecipes
import com.umut.poele.data.source.local.relation.UserWithRecipeCategoriesWithRecipes
import com.umut.poele.data.source.local.relation.UserWithRecipes
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.domain.repository.RecipeRepository
import com.umut.poele.domain.use_case.GetRecipesUseCase
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.ui.choose.SelectedUser
import com.umut.poele.util.FilterListener
import com.umut.poele.util.RecipeDatabaseListener
import com.umut.poele.util.SearchBarListener
import com.umut.poele.util.ShopListListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeRecipeViewModel @Inject constructor(
    private val recipeDao: RecipeDao,
    private val getRecipesUseCase: GetRecipesUseCase
) : BaseViewModel(), RecipeDatabaseListener, SearchBarListener, FilterListener, ShopListListener {

    private var _recipeCategoryListLiveData: MutableLiveData<List<RecipeCategoryWithRecipes>> = MutableLiveData()
    val recipeCategoryListLiveData get() = _recipeCategoryListLiveData

    private val _recipeList = MutableLiveData<List<RecipeBasic>>()
    val recipeList : LiveData<List<RecipeBasic>> = _recipeList

    private val _recipeInfo = MutableLiveData<RecipeBasic>()
    val recipeInfo : LiveData<RecipeBasic> = _recipeInfo

    private val allRecipeList = mutableListOf<List<RecipeBasic>>()

    private val _allRecipeListLiveData = MutableLiveData<List<List<RecipeBasic>>>()
    val allRecipeListLiveData get() = _allRecipeListLiveData

    val recipeCategoryList = listOf(
        RecipeCategoryEntity("main course"),
        RecipeCategoryEntity("side dish"),
        RecipeCategoryEntity("dessert"),
        RecipeCategoryEntity("appetizer"),
        RecipeCategoryEntity("salad"))

    init {
        getAllRecipeCategories()
        getUserWithRecipesAndCategories(SelectedUser.userId)

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

    private fun getUserWithRecipesAndCategories(userId: Int){
        val list = mutableListOf<List<UserWithRecipeCategoriesWithRecipes>>()
        viewModelScope.launch {
            recipeDao.getUsersWithRecipesAndCategories().collect{
                list.add(it)
                Log.i("umutcan", "it:${it.last().recipes.first().categories.last()}")
            }
        }
    }


    fun getAllRecipesWithUserId(userId: Int): LiveData<UserWithRecipes> = recipeDao.getAllRecipesOfUser(userId).asLiveData()

    private fun getRecipesWithCategory(recipeCategoryTitle: String): Flow<RecipeCategoryWithRecipes> =
        recipeDao.getRecipesWithCategory(recipeCategoryTitle)

    fun onBackClicked() {
        navigateBack()
    }

    override fun onRecipeClicked(clickedRecipe: RecipeBasic) {
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

    init {
        getAllCategoryRecipes()
//        getRecipes()
    }

    private fun getAllCategoryRecipes() {
        recipeCategoryList.forEach{
            getRecipesWithType(it.recipeCategoryTitle)
        }
    }

    private fun getRecipes() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) { getRecipesUseCase.getRecipes(10)}
            _recipeList.value = result.data ?: emptyList()

            getRecipeInfo(result.data?.first()?.id ?: -1, false)
        }
    }

    private fun getRecipesWithType(type:String) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {getRecipesUseCase.getRecipesWithType(type)}
            Log.i("umutcan", "result data: ${result.data?.first()?.title}")
            result.data?.let { allRecipeList.add(it) }
            if (allRecipeList.size == recipeCategoryList.size) {
                _allRecipeListLiveData.value = allRecipeList
            }
        }
    }

    private fun getRecipeInfo(id: Int, includeNutrition: Boolean){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) { getRecipesUseCase.getRecipeInfo(id, includeNutrition)}
            _recipeInfo.value = result.data ?: RecipeBasic()
        }

    }

}
