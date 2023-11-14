package com.umut.poele.ui.search

import com.umut.poele.model.Recipe
import com.umut.poele.model.Supply
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.RecipeListener
import com.umut.poele.util.SupplyListener

class SearchViewModel : BaseViewModel(), RecipeListener, SupplyListener {
    fun onBackClicked() {
        navigateBack()
    }

    override fun onRecipeClicked(clickedRecipe: Recipe) {
        navigate(SearchFragmentDirections.actionSearchFragmentToHomeRecipeDetailFragment())
    }

    override fun onSupplyClicked(clickedSupply: Supply) {
        navigate(SearchFragmentDirections.actionSearchFragmentToFridgeFirstFragment())
    }
}
