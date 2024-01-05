package com.umut.poele.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.umut.poele.R
import com.umut.poele.databinding.FragmentSearchRecipeBinding
import com.umut.poele.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchRecipeFragment
    : BaseFragment<FragmentSearchRecipeBinding, SearchViewModel>(R.layout.fragment_search_recipe) {

    override val vm: SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            vm.recentRecipeListLiveData.observe(viewLifecycleOwner) {
                adapter = SearchRecipeAdapter(it, vm)
            }
        }
    }
}
