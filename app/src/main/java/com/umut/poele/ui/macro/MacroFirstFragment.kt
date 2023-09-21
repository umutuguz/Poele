package com.umut.poele.ui.macro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umut.poele.R
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.databinding.FragmentMacroFirstBinding
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.ui.home.HomeFirstViewModel

class MacroFirstFragment : BaseFragment<FragmentMacroFirstBinding, BaseViewModel>
    (R.layout.fragment_macro_first, true) {

    override val vm: BaseViewModel
        get() = HomeFirstViewModel()
}
