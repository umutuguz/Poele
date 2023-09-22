package com.umut.poele.ui.recipe_detail

import com.umut.poele.model.RecipeDetail
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.RecipeDetailListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeRecipeDetailViewModel @Inject constructor(): BaseViewModel(), RecipeDetailListener {
    fun navigateUp() {
        navigateBack()
    }

    override fun onRecipeDetailClicked(clickedRecipeDetail: RecipeDetail) {
        navigate(HomeRecipeDetailFragmentDirections.actionHomeRecipeDetailFragmentToHomeRecipeFragment())
    }
}
