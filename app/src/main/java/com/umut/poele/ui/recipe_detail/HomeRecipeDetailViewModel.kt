package com.umut.poele.ui.recipe_detail

import com.umut.poele.model.RecipeDetail
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.RecipeDetailListener
import com.umut.poele.util.ShopListListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeRecipeDetailViewModel @Inject constructor(): BaseViewModel(), RecipeDetailListener, ShopListListener {
    fun navigateUp() {
        navigateBack()
    }

    override fun onRecipeDetailClicked(clickedRecipeDetail: RecipeDetail) {
        navigate(HomeRecipeDetailFragmentDirections.actionHomeRecipeDetailFragmentToHomeRecipeFragment())
    }

    override fun onShopListClicked() {
        navigate(HomeRecipeDetailFragmentDirections.actionHomeRecipeDetailFragmentToShopListFragment())

    }
}
