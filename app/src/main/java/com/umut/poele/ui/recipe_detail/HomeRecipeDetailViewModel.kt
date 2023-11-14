package com.umut.poele.ui.recipe_detail

import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.ShopListListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeRecipeDetailViewModel @Inject constructor() : BaseViewModel(), ShopListListener {

    fun navigateUp() {
        navigateBack()
    }

    override fun onShopListClicked() {
        navigate(HomeRecipeDetailFragmentDirections.actionHomeRecipeDetailFragmentToShopListFragment())

    }
}
