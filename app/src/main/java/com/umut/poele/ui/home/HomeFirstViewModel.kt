package com.umut.poele.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.umut.poele.data.source.local.entity.RecipeCategoryEntity
import com.umut.poele.data.source.local.entity.MenuCardEntity
import com.umut.poele.data.source.local.dao.RecipeDao
import com.umut.poele.data.source.local.dao.UserDao
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.ChooseChefListener
import com.umut.poele.util.ChooseHomeListener
import com.umut.poele.util.RecipeCategoryListener
import com.umut.poele.util.SearchBarListener
import com.umut.poele.util.ShopListListener

class HomeFirstViewModel(
    private val userDao: UserDao,
    private val recipeDao: RecipeDao
    ) : BaseViewModel(),
    RecipeCategoryListener,
        ChooseHomeListener,
        ChooseChefListener,
        SearchBarListener,
        ShopListListener {

    fun getMenuCardWithUserId(userId: Int): LiveData<List<MenuCardEntity>> = userDao.getMenuCardWithUserId(userId).asLiveData()

    fun getAllRecipeCategories(): LiveData<List<RecipeCategoryEntity>> = recipeDao.getAllRecipeCategories().asLiveData()

    override fun onRecipeCategoryClicked(clickedRecipeCategory: RecipeCategoryEntity) {
        navigate(HomeFirstFragmentDirections.actionHomeFirstFragmentToHomeRecipeFragment(clickedRecipeCategory))
    }

    override fun onChooseHomeClicked() {
        navigate(HomeFirstFragmentDirections.actionHomeFirstFragmentToChooseHomeDialog(), true)
    }

    override fun onChooseChefClicked() {
        navigate(HomeFirstFragmentDirections.actionHomeFirstFragmentToChooseChefDialog(), true)
    }

    override fun onSearchBarClicked() {
        navigate(HomeFirstFragmentDirections.actionHomeFirstFragmentToSearchFragment())
    }

    override fun onShopListClicked() {
        navigate(HomeFirstFragmentDirections.actionHomeFirstFragmentToShopListFragment())
    }

}

class HomeFirstViewModelFactory(
    private val userDao: UserDao,
    private val recipeDao: RecipeDao,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeFirstViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return HomeFirstViewModel(userDao, recipeDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
