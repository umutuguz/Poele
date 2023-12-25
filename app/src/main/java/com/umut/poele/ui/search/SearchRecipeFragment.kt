package com.umut.poele.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.umut.poele.R
import com.umut.poele.domain.model.RecipeDataSource
import com.umut.poele.databinding.FragmentSearchRecipeBinding
import com.umut.poele.ui.base.BaseFragment

class SearchRecipeFragment : BaseFragment<FragmentSearchRecipeBinding, SearchViewModel>(R.layout.fragment_search_recipe) {

    override val vm: SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            adapter = SearchRecipeAdapter(RecipeDataSource().loadRecipe(), vm)
        }
    }
}
