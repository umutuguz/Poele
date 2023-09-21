package com.umut.poele.ui.home

import com.umut.poele.model.FoodCategory
import com.umut.poele.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeFirstViewModel @Inject constructor() : BaseViewModel(), FoodCategoryListener {

    override fun onFoodCategoryClicked(clickedFoodCategory: FoodCategory) {
        navigate(
            HomeFirstFragmentDirections.actionHomeFirstFragmentToHomeRecipeFragment()
        )
    }

}
