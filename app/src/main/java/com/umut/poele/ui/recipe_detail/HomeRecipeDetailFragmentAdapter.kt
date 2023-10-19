package com.umut.poele.ui.recipe_detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.umut.poele.ui.base.BaseFragmentStateAdapter

class HomeRecipeDetailFragmentAdapter(
    private val dataset: List<Fragment>, fragmentManager:
    FragmentManager, lifecycle: Lifecycle
) :
    BaseFragmentStateAdapter<Fragment>(dataset, fragmentManager, lifecycle) {


}
