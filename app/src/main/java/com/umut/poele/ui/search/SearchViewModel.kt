package com.umut.poele.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.domain.model.RecipeModel
import com.umut.poele.domain.model.Supply
import com.umut.poele.domain.use_case.GetRecipesUseCase
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.RecipeListener
import com.umut.poele.util.SupplyListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val getRecipesUseCase: GetRecipesUseCase)
    : BaseViewModel(), RecipeListener, SupplyListener {

        private val _recentRecipeListLiveData = MutableLiveData<List<RecipeBasic>>()
    val recentRecipeListLiveData get() = _recentRecipeListLiveData
    fun onBackClicked() {
        navigateBack()
    }

    init {
        getRecentRecipes()
    }

    override fun onRecipeClicked(clickedRecipe: RecipeBasic) {
        navigate(SearchFragmentDirections.actionSearchFragmentToHomeRecipeDetailFragment(clickedRecipe))
    }

    override fun onSupplyClicked(clickedSupply: Supply) {
        navigate(SearchFragmentDirections.actionSearchFragmentToFridgeFirstFragment())
    }

    private fun getRecentRecipes() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {getRecipesUseCase.getRecipes(5)}
            result.data?.let {
                _recentRecipeListLiveData.value = it
            }
        }
    }
}
