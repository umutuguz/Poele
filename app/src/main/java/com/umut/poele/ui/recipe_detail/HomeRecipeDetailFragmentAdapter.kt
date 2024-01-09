package com.umut.poele.ui.recipe_detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.ui.base.BaseDetailFragment
import com.umut.poele.ui.base.BaseFragmentStateAdapter

class HomeRecipeDetailFragmentAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private val dataset = mutableListOf<BaseDetailFragment>()
    private var recipe = RecipeBasic()
    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun createFragment(position: Int): Fragment {
        return dataset[position]
    }

    fun submitRecipe(clickedRecipe: RecipeBasic) {
        dataset.forEach {
            it.updateRecipe(clickedRecipe)
        }
    }

    fun submitFragmentList(list : List<BaseDetailFragment>) {
        dataset.clear()
        dataset.addAll(list)
    }

}
