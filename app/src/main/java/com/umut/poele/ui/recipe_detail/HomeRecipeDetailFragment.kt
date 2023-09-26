package com.umut.poele.ui.recipe_detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.umut.poele.R
import com.umut.poele.databinding.FragmentHomeRecipeDetailBinding
import com.umut.poele.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

val TAB_NAME = listOf<String>("Info", "Ingredient", "Direction")

@AndroidEntryPoint
class HomeRecipeDetailFragment : BaseFragment<FragmentHomeRecipeDetailBinding,
        HomeRecipeDetailViewModel>(R.layout.fragment_home_recipe_detail, false) {

    override val vm: HomeRecipeDetailViewModel by viewModels()
    private val fragments = listOf<Fragment>(
        HomeRecipeDetailInfoFragment(),
        HomeRecipeDetailIngredientFragment(), HomeRecipeDetailDirectionFragment()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            adapter = HomeRecipeDetailFragmentAdapter(
                fragments,
                requireActivity().supportFragmentManager,
                lifecycle
            )
            viewpagerFragment.adapter = HomeRecipeDetailFragmentAdapter(
                fragments,
                requireActivity().supportFragmentManager,
                lifecycle
            )
        }

        TabLayoutMediator(binding.tabFragment, binding.viewpagerFragment) { tab, position ->
            tab.text = TAB_NAME[position]
        }
            .attach()
    }
}
