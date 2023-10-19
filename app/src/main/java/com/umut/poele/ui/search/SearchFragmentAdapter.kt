package com.umut.poele.ui.search

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.umut.poele.ui.base.BaseFragmentStateAdapter

class SearchFragmentAdapter(private val dataset: List<Fragment>, fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    BaseFragmentStateAdapter<Fragment>(dataset, fragmentManager, lifecycle)
