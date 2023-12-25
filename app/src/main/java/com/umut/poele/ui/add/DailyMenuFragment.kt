package com.umut.poele.ui.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import com.google.android.material.tabs.TabLayoutMediator
import com.umut.PoeleApplication
import com.umut.poele.R
import com.umut.poele.databinding.FragmentDailyMenuBinding
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.ui.login.AccountInfo
import com.umut.poele.util.Constant
import kotlinx.coroutines.launch

class DailyMenuFragment : BaseFragment<FragmentDailyMenuBinding, DailyMenuViewModel>(R.layout.fragment_daily_menu) {

    override val vm: DailyMenuViewModel by activityViewModels {
        DailyMenuViewModelFactory((activity?.application as PoeleApplication).database.userDao())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewModel = vm

            lifecycle.coroutineScope.launch {
                vm.getMenuCardWithUserId(AccountInfo.accountUserId).collect{

                    viewpagerDailyMenu.adapter = EnterDailyMenuTabAdapter(loadMenuCardModel(it))

                    TabLayoutMediator(binding.tabMenu, binding.viewpagerDailyMenu) {tab, position ->
                        tab.text = Constant.ENTER_DAILY_MENU_TAB_NAME[position]
                    }.attach()
                }
            }
        }

    }
}
