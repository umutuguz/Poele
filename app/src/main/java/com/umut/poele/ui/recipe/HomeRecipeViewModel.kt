package com.umut.poele.ui.recipe

import com.umut.poele.model.Recipe
import com.umut.poele.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeRecipeViewModel @Inject constructor() : BaseViewModel(), RecipeListener {

    fun goBackClicked() {
        navigateBack()
    }

    override fun onRecipeClicked(clickedRecipe: Recipe) {
        navigate(HomeRecipeFragmentDirections.actionHomeRecipeFragmentToHomeFirstFragment())
    }
}
