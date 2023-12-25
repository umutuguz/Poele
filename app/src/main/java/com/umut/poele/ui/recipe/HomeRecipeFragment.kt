package com.umut.poele.ui.recipe


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.umut.PoeleApplication
import com.umut.poele.R
import com.umut.poele.data.source.local.entity.RecipeCategoryEntity
import com.umut.poele.data.source.local.entity.RecipeEntity
import com.umut.poele.data.source.local.relation.RecipeCategoryWithRecipes
import com.umut.poele.databinding.FragmentHomeRecipeBinding
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.ui.choose.SelectedUser


class HomeRecipeFragment : BaseFragment<FragmentHomeRecipeBinding, HomeRecipeViewModel>(
    R.layout.fragment_home_recipe
) {

    override val vm: HomeRecipeViewModel by activityViewModels {
        HomeRecipeViewModelFactory((activity?.application as PoeleApplication).database.recipeDao())
    }

    private val navArgs: HomeRecipeFragmentArgs by navArgs()

//    private var recipeTabAdapter: RecipeTabAdapter? = null

    private var recipeList: MutableList<RecipeEntity> = mutableListOf()
    private var recipeCategoryList: MutableList<RecipeCategoryWithRecipes> = mutableListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel = vm
            Log.i("umutcan", "onViewCreated")

            vm.getAllRecipesWithUserId(SelectedUser.userId).observe(this@HomeRecipeFragment.viewLifecycleOwner){userWithRecipesList->
                Log.i("umutcan", "observe getAllRecipesWithUserId")
                recipeList = userWithRecipesList.recipes.toMutableList()
                setRecipeCategoryViewPager()
            }

            vm.recipeCategoryListLiveData.observe(this@HomeRecipeFragment.viewLifecycleOwner){ recipeCategoryListObserve->
                Log.i("umutcan", "observe recipeCategoryListLiveData")

                recipeCategoryList = recipeCategoryListObserve.toMutableList()
                setRecipeCategoryViewPager()
            }
        }
    }

    private fun setRecipeCategoryViewPager(){
//        Log.i("umutcan", "setRecipeCategoryViewPager")
//        Log.i("umutcan", "recipeList:${recipeList.size}")
//        Log.i("umutcan", "recipeCategoryList:${recipeCategoryList.size}")
        if (recipeList.isNotEmpty() && recipeCategoryList.isNotEmpty()){
            val recipeTabList: MutableList<RecipeCategoryEntity> = mutableListOf()
            val categoryRecipeList: MutableList<RecipeEntity> = mutableListOf()

            recipeCategoryList.forEach {
                recipeTabList.add(it.recipeCategory)
            }

            var tabIndex: Int = recipeTabList.indexOf(navArgs.clickedRecipeCategory)

            categoryRecipeList.addAll(recipeList.intersect(recipeCategoryList[tabIndex].recipes.toSet()))
            binding.viewpagerRecipeCategory.adapter = RecipeTabAdapter(recipeTabList, vm, categoryRecipeList)

            TabLayoutMediator(binding.tabRecipeCategory, binding.viewpagerRecipeCategory) {tab, position ->
                tab.text = recipeCategoryList[position].recipeCategory.recipeCategoryTitle
            }.attach()

            binding.tabRecipeCategory.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

                override fun onTabSelected(tab: TabLayout.Tab?) {
                    Log.i("umutcan", "onTabSelected ${tab?.text}")

                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    Log.i("umutcan", "onTabUnselected ${tab?.text}")
//                    tabIndex = binding.tabRecipeCategory.selectedTabPosition
//                    categoryRecipeList.addAll(recipeList.intersect(recipeCategoryList[tabIndex].recipes.toSet()))
//                    binding.viewpagerRecipeCategory.adapter = RecipeTabAdapter(recipeTabList, vm, categoryRecipeList)
//
//                    TabLayoutMediator(binding.tabRecipeCategory, binding.viewpagerRecipeCategory) {tab, position ->
//                        tab.text = recipeCategoryList[position].recipeCategory.recipeCategoryTitle
//                    }.attach()
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                    Log.i("umutcan", "onTabReselected ${tab?.text}")
                }
            })

//            categoryRecipeList.addAll(recipeList.intersect(recipeCategoryList[tabIndex].recipes.toSet()))
//            binding.viewpagerRecipeCategory.adapter = RecipeTabAdapter(recipeTabList, vm, categoryRecipeList)

            binding.tabRecipeCategory.selectTab(binding.tabRecipeCategory.getTabAt(recipeTabList.indexOf(navArgs.clickedRecipeCategory)))
        }
    }
}
