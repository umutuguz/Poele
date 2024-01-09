package com.umut.poele.ui.recipe_detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.umut.poele.R
import com.umut.poele.databinding.FragmentHomeRecipeDetailBinding
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.util.Constant.RECIPE_DETAIL_TAB_NAME
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeRecipeDetailFragment : BaseFragment<FragmentHomeRecipeDetailBinding, HomeRecipeDetailViewModel>(R.layout.fragment_home_recipe_detail) {

    override val vm: HomeRecipeDetailViewModel by viewModels()
    private val args: HomeRecipeDetailFragmentArgs by navArgs()
    lateinit var adapter: HomeRecipeDetailFragmentAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = HomeRecipeDetailFragmentAdapter(requireActivity().supportFragmentManager, lifecycle)

        binding.apply {
            var result = RecipeBasic()
            args.clickedRecipe?.let { clickedRecipe ->
                vm.getRecipeInfo(clickedRecipe.id, true)

                adapter.submitFragmentList(listOf(HomeRecipeDetailInfoFragment()))
                viewpagerFragment.adapter = adapter

                vm.recipeInfoLiveData.observe(viewLifecycleOwner) { recipe ->
                    result = recipe
                    adapter.submitRecipe(recipe)
                }
            }

            TabLayoutMediator(tabFragment, viewpagerFragment) { tab, position ->
                tab.text = RECIPE_DETAIL_TAB_NAME[position]
            }.attach()

            buttonAddShoplist.setOnClickListener {
                vm.addShopListSupply(result)
                vm.addShopList(result)
            }
            viewModel = vm
        }
    }
}
