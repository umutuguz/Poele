package com.umut.poele.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umut.poele.R
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.databinding.FragmentLoginBinding
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.ui.home.HomeFirstViewModel

class LoginFragment : BaseFragment<FragmentLoginBinding, BaseViewModel>(
    R.layout.fragment_login,
    false) {

    override val vm: BaseViewModel
        get() = HomeFirstViewModel()
}
