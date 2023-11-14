package com.umut.poele.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
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

            recyclerRecipeCategories.adapter?.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY

            viewpagerMenuCard.adapter = MenuCardAdapter(MenuCardDataSource().loadMenuCards())

        }

    }

}
