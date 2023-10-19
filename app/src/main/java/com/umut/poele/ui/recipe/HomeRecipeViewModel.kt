package com.umut.poele.ui.recipe

import com.umut.poele.model.Recipe
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.FilterListener
import com.umut.poele.util.RecipeListener
import com.umut.poele.util.SearchBarListener
import com.umut.poele.util.ShopListListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeRecipeViewModel @Inject constructor() : BaseViewModel(), RecipeListener, SearchBarListener, FilterListener, ShopListListener {

    fun goBackClicked() {
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
