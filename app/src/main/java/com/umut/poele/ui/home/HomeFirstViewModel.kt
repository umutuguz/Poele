package com.umut.poele.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.umut.poele.database.address.AddressDao
import com.umut.poele.database.category.RecipeCategory
import com.umut.poele.database.menu.MenuCard
import com.umut.poele.database.menu.MenuCardDao
import com.umut.poele.database.recipe.RecipeDao
import com.umut.poele.database.user.UserDao
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.ChooseChefListener
import com.umut.poele.util.ChooseHomeListener
import com.umut.poele.util.RecipeCategoryListener
import com.umut.poele.util.SearchBarListener
import com.umut.poele.util.ShopListListener
import kotlinx.coroutines.flow.Flow


class HomeFirstViewModel(
    private val userDao: UserDao,
    private val recipeDao: RecipeDao
    ) : BaseViewModel(),
    RecipeCategoryListener,
        ChooseHomeListener,
        ChooseChefListener,
        SearchBarListener,
        ShopListListener {

    fun getMenuCardWithUserId(userId: Int): LiveData<List<MenuCard>> = userDao.getMenuCardWithUserId(userId).asLiveData()

    fun getAllRecipeCategories(): LiveData<List<RecipeCategory>> = recipeDao.getAllRecipeCategories().asLiveData()

    override fun onRecipeCategoryClicked(clickedRecipeCategory: RecipeCategory) {
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
