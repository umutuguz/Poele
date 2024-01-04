package com.umut.poele.ui.search

import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.domain.model.RecipeModel
import com.umut.poele.domain.model.Supply
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.RecipeListener
import com.umut.poele.util.SupplyListener

class SearchViewModel : BaseViewModel(), RecipeListener, SupplyListener {
    fun onBackClicked() {
        navigateBack()
    }

    override fun onRecipeClicked(clickedRecipe: RecipeBasic) {
        navigate(SearchFragmentDirections.actionSearchFragmentToHomeRecipeDetailFragment(clickedRecipe))
    }

    override fun onSupplyClicked(clickedSupply: Supply) {
        navigate(SearchFragmentDirections.actionSearchFragmentToFridgeFirstFragment())
    }
}
