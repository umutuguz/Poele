package com.umut.poele.ui.signup

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.umut.PoeleApplication
import com.umut.poele.R
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.databinding.FragmentSignupBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class SignupFragment : BaseFragment<FragmentSignupBinding, SignupViewModel>(
    R.layout.fragment_signup
) {

    override val vm: SignupViewModel by viewModels<SignupViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            buttonSignUp.setOnClickListener {
                vm.emailState.value = textInputEmail.editText?.text.toString()
                vm.password.value = textInputPassword.editText?.text.toString()
                vm.onSignupClicked(textInputEmail.editText?.text.toString())
            }
        }
    }
}
