package com.umut.poele.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.umut.poele.R
import com.umut.poele.databinding.FragmentSearchBarBinding
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.util.Constants.SEARCH_TAB_NAME

class SearchFragment : BaseFragment<FragmentSearchBarBinding, SearchViewModel>(R.layout.fragment_search_bar) {

    override val vm: SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragments: List<Fragment> = listOf(SearchRecipeFragment(), SearchIngredientFragment())

        binding.apply {
            adapterFragment = SearchFragmentAdapter(fragments, requireActivity().supportFragmentManager, lifecycle)
            adapterPopular = SearchPopularAdapter(listOf("egg", "burger", "banana", "rice", "chicken", "lasagne", "fettuccine"))
            adapterRecent = SearchRecentAdapter(listOf("brownie", "cookie", "tenderloin", "chia", "egg"))
            viewpagerSearch.adapter = SearchFragmentAdapter(fragments, requireActivity().supportFragmentManager, lifecycle)
        }

        TabLayoutMediator(binding.tabFragment, binding.viewpagerSearch) { tab, position ->
            tab.text = SEARCH_TAB_NAME[position]
        }.attach()
    }
}
