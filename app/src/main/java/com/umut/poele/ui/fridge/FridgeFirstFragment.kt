package com.umut.poele.ui.fridge

import com.umut.poele.R
import com.umut.poele.databinding.FragmentFridgeFirstBinding
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.ui.home.HomeFirstViewModel

class FridgeFirstFragment : BaseFragment<FragmentFridgeFirstBinding, BaseViewModel>
    (R.layout.fragment_fridge_first, true) {

    override val vm: BaseViewModel
        get() = HomeFirstViewModel()
}
