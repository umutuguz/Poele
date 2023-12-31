package com.umut.poele.ui.profile

import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.domain.model.RecipeModel
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.RecipeListener

class FavoriteViewModel : BaseViewModel(), RecipeListener {

    fun onBackClicked(){
        navigateBack()
    }

    override fun onRecipeClicked(clickedRecipe: RecipeBasic) {
        navigate(FavoriteFragmentDirections.actionFavoriteFragmentToHomeRecipeDetailFragment(clickedRecipe))
    }
}
