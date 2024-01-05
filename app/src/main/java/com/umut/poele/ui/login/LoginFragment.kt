package com.umut.poele.ui.login

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.umut.poele.BuildConfig
import com.umut.poele.R
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>(
    R.layout.fragment_login
) {

    override val vm: LoginViewModel by viewModels<LoginViewModel>()

    private val args: LoginFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (BuildConfig.DEBUG) {
            binding.apply {
                textUsername.editText?.setText("umutuguzlar7@gmail.com")
                textPassword.editText?.setText("cancan")
            }
        }
        binding.apply {
            viewModel = vm

            buttonLogin.setOnClickListener {
                vm.email.value = textUsername.editText?.text.toString()
                vm.password.value = textPassword.editText?.text.toString()

                vm.onLoginClicked()
            }
            textGuest.setOnClickListener{
                vm.onGuestClicked()
            }
        }
    }
}

object AccountInfo {

    var accountUserId: Int = 1
}
