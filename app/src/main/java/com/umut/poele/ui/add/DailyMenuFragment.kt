package com.umut.poele.ui.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.umut.poele.R
import com.umut.poele.data.MenuCardDataSource
import com.umut.poele.databinding.FragmentDailyMenuBinding
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.util.Constants

class DailyMenuFragment : BaseFragment<FragmentDailyMenuBinding, DailyMenuViewModel>(R.layout.fragment_daily_menu) {

    override val vm: DailyMenuViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewModel = vm
            viewpagerDailyMenu.adapter = EnterDailyMenuTabAdapter(MenuCardDataSource().loadMenuCards())
        }

        TabLayoutMediator(binding.tabMenu, binding.viewpagerDailyMenu) {tab, position ->
            tab.text = Constants.ENTER_DAILY_MENU_TAB_NAME[position]
        }.attach()
    }
}
