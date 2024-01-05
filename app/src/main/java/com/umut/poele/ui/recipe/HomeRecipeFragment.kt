package com.umut.poele.ui.recipe


import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.umut.poele.R
import com.umut.poele.databinding.FragmentHomeRecipeBinding
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.util.MealTypes
import com.umut.poele.util.toMealCategoryList
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class HomeRecipeFragment : BaseFragment<FragmentHomeRecipeBinding, HomeRecipeViewModel>(
    R.layout.fragment_home_recipe
) {

    override val vm: HomeRecipeViewModel by activityViewModels()
    private val navArgs: HomeRecipeFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            vm.allRecipeListLiveData.observe(viewLifecycleOwner){

                viewpagerRecipeCategory.adapter = RecipeTabAdapter(vm.recipeCategoryList, vm, it)

                TabLayoutMediator(binding.tabRecipeCategory, binding.viewpagerRecipeCategory) {tab, position ->
                    tab.text = MealTypes.MAINCOURSE.toMealCategoryList()[position].title
                }.attach()

            }
            tabRecipeCategory.selectTab(
                tabRecipeCategory.getTabAt(vm.recipeCategoryList.indexOf(navArgs.clickedMealCategory))
            )

        }
    }

}
