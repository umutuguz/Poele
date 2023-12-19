package com.umut.poele.ui.recipe_detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.umut.poele.R
import com.umut.poele.databinding.FragmentHomeRecipeDetailBinding
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.util.Constants.RECIPE_DETAIL_TAB_NAME
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeRecipeDetailFragment : BaseFragment<FragmentHomeRecipeDetailBinding, HomeRecipeDetailViewModel>(R.layout.fragment_home_recipe_detail) {

    override val vm: HomeRecipeDetailViewModel by viewModels()
    private val fragments = listOf<Fragment>(
        HomeRecipeDetailInfoFragment(), HomeRecipeDetailIngredientFragment(), HomeRecipeDetailDirectionFragment()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewpagerFragment.adapter = HomeRecipeDetailFragmentAdapter(
            fragments, requireActivity().supportFragmentManager, lifecycle
        )
        binding.viewModel = vm

        TabLayoutMediator(binding.tabFragment, binding.viewpagerFragment) { tab, position ->
            tab.text = RECIPE_DETAIL_TAB_NAME[position]
        }.attach()

    }
}
