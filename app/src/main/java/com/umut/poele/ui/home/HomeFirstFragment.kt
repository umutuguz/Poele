package com.umut.poele.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.umut.poele.MainActivity
import com.umut.poele.R
import com.umut.poele.data.FoodCategoryDataSource
import com.umut.poele.data.MenuCardDataSource
import com.umut.poele.databinding.FragmentHomeFirstBinding
import com.umut.poele.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFirstFragment :
    BaseFragment<FragmentHomeFirstBinding, HomeFirstViewModel>(R.layout.fragment_home_first) {

    override val vm: HomeFirstViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            adapterFoodCategory =
                FoodCategoryAdapter(FoodCategoryDataSource().loadFoodCategory(), vm)
            adapterMenuCard = MenuCardAdapter(MenuCardDataSource().loadMenuCards())
            list = FoodCategoryDataSource()
        }

    }

}
