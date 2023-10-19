package com.umut.poele.ui.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

abstract class BaseFragmentStateAdapter<T : Fragment>(
    private val dataset: List<T>, val fragmentManager: FragmentManager, val lifecycle:
Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = dataset.size

    override fun createFragment(position: Int): Fragment = dataset[position]

}
