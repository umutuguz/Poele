package com.umut.poele.ui.home

import com.umut.poele.model.FoodCategory
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.AddRecipeListener
import com.umut.poele.util.ChooseChefListener
import com.umut.poele.util.ChooseHomeListener
import com.umut.poele.util.FoodCategoryListener
import com.umut.poele.util.SearchBarListener
import com.umut.poele.util.ShopListListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeFirstViewModel @Inject constructor() : BaseViewModel(), FoodCategoryListener, ChooseHomeListener, ChooseChefListener, SearchBarListener,
    ShopListListener{

    private var retrofit: String? = null

    fun setRetrofit(string: String) {
        retrofit = string
    }

    override fun onFoodCategoryClicked(clickedFoodCategory: FoodCategory) {
        navigate(HomeFirstFragmentDirections.actionHomeFirstFragmentToHomeRecipeFragment())
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
