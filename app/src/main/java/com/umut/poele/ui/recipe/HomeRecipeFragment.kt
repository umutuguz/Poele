package com.umut.poele.ui.recipe


import android.os.Bundle
import android.view.View
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

    override val vm: HomeRecipeViewModel by viewModels<HomeRecipeViewModel>()
    private val navArgs: HomeRecipeFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            vm.allRecipeListLiveData.observe(viewLifecycleOwner){

                viewpagerRecipeCategory.adapter = RecipeTabAdapter(vm.recipeCategoryList, vm, it)

                TabLayoutMediator(binding.tabRecipeCategory, binding.viewpagerRecipeCategory) {tab, position ->
                    tab.text = MealTypes.MAINCOURSE.toMealCategoryList()[position].title
                }.attach()

                tabRecipeCategory.selectTab(
                    binding.tabRecipeCategory.getTabAt(vm.recipeCategoryList.indexOf(navArgs.clickedMealCategory))
                )
            }

        }
    }

}

//binding.apply {
//    viewModel = vm
//    Log.i("umutcan", "onViewCreated")
//
//    vm.getAllRecipesWithUserId(SelectedUser.userId).observe(this@HomeRecipeFragment.viewLifecycleOwner){userWithRecipesList->
//        Log.i("umutcan", "observe getAllRecipesWithUserId")
//        recipeList = userWithRecipesList.recipes.toMutableList()
//        setRecipeCategoryViewPager()
//    }
//
//    vm.recipeCategoryListLiveData.observe(this@HomeRecipeFragment.viewLifecycleOwner){ recipeCategoryListObserve->
//        Log.i("umutcan", "observe recipeCategoryListLiveData")
//
//        recipeCategoryList = recipeCategoryListObserve.toMutableList()
//        setRecipeCategoryViewPager()
//    }
//}



//private fun setRecipeCategoryViewPager(){
//    if (recipeList.isNotEmpty() && recipeCategoryList.isNotEmpty()){
//        val recipeTabList: MutableList<RecipeCategoryEntity> = mutableListOf()
//        val categoryRecipeList: MutableList<RecipeEntity> = mutableListOf()
//
//        recipeCategoryList.forEach {
//            recipeTabList.add(it.recipeCategory)
//        }
//
//        var tabIndex: Int = recipeTabList.indexOf(navArgs.clickedRecipeCategory)
//
//        categoryRecipeList.addAll(recipeList.intersect(recipeCategoryList[tabIndex].recipes.toSet()))
//        binding.viewpagerRecipeCategory.adapter = RecipeTabAdapter(recipeTabList, vm, categoryRecipeList)
//
//        TabLayoutMediator(binding.tabRecipeCategory, binding.viewpagerRecipeCategory) {tab, position ->
//            tab.text = recipeCategoryList[position].recipeCategory.recipeCategoryTitle
//        }.attach()
//
//        binding.tabRecipeCategory.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                Log.i("umutcan", "onTabSelected ${tab?.text}")
//
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                Log.i("umutcan", "onTabUnselected ${tab?.text}")
////                    tabIndex = binding.tabRecipeCategory.selectedTabPosition
////                    categoryRecipeList.addAll(recipeList.intersect(recipeCategoryList[tabIndex].recipes.toSet()))
////                    binding.viewpagerRecipeCategory.adapter = RecipeTabAdapter(recipeTabList, vm, categoryRecipeList)
////
////                    TabLayoutMediator(binding.tabRecipeCategory, binding.viewpagerRecipeCategory) {tab, position ->
////                        tab.text = recipeCategoryList[position].recipeCategory.recipeCategoryTitle
////                    }.attach()
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                Log.i("umutcan", "onTabReselected ${tab?.text}")
//            }
//        })
//
////            categoryRecipeList.addAll(recipeList.intersect(recipeCategoryList[tabIndex].recipes.toSet()))
////            binding.viewpagerRecipeCategory.adapter = RecipeTabAdapter(recipeTabList, vm, categoryRecipeList)
//
//        binding.tabRecipeCategory.selectTab(binding.tabRecipeCategory.getTabAt(recipeTabList.indexOf(navArgs.clickedRecipeCategory)))
//    }
//}
