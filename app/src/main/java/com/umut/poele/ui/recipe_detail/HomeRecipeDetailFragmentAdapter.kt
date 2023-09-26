package com.umut.poele.ui.recipe_detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeRecipeDetailFragmentAdapter(private val dataset: List<Fragment>, fragmentManager:
FragmentManager, lifecycle: Lifecycle
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = dataset.size

    override fun createFragment(position: Int): Fragment = dataset[position]
}
