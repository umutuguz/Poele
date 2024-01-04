package com.umut.poele.ui.recipe_detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.umut.poele.R
import com.umut.poele.databinding.FragmentHomeRecipeDetailBinding
import com.umut.poele.domain.model.Equipment
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.util.Constant.RECIPE_DETAIL_TAB_NAME
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeRecipeDetailFragment
    : BaseFragment<FragmentHomeRecipeDetailBinding, HomeRecipeDetailViewModel>(R.layout.fragment_home_recipe_detail) {

    override val vm: HomeRecipeDetailViewModel by viewModels()
    private val args: HomeRecipeDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            args.clickedRecipe?.let { clickedRecipe ->
                Log.i("umutcan", "recipeInfoId: ${clickedRecipe.id}")
                vm.getRecipeInfo(clickedRecipe.id, true)

                vm.recipeInfoLiveData.observe(viewLifecycleOwner) {
                    viewpagerFragment.adapter = HomeRecipeDetailFragmentAdapter(
                        loadFragments(it), requireActivity().supportFragmentManager, lifecycle
                    )
                    TabLayoutMediator(tabFragment, viewpagerFragment) { tab, position ->
                        tab.text = RECIPE_DETAIL_TAB_NAME[position]
                    }.attach()
                }
                buttonAddShoplist.setOnClickListener {
                    vm.addShopList(clickedRecipe)
                }
            }
            viewModel = vm
        }
    }

    private fun loadFragments(recipe: RecipeBasic): List<Fragment> {
        return listOf(
            HomeRecipeDetailInfoFragment(recipe),
            HomeRecipeDetailIngredientFragment(recipe),
            HomeRecipeDetailDirectionFragment(recipe)
        )
    }

}
