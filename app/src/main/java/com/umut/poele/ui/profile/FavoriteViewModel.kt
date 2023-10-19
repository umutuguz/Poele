package com.umut.poele.ui.profile

import com.umut.poele.model.Recipe
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.RecipeListener

class FavoriteViewModel : BaseViewModel(), RecipeListener {

    fun onBackClicked(){
        navigateBack()
    }

    override fun onRecipeClicked(clickedRecipe: Recipe) {
        navigate(FavoriteFragmentDirections.actionFavoriteFragmentToHomeRecipeDetailFragment())
    }
}
