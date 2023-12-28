package com.umut.poele.ui.login

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.umut.PoeleApplication
import com.umut.poele.R
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.databinding.FragmentLoginBinding
import com.umut.poele.di.ServiceModule
import com.umut.poele.ui.choose.SelectedUser
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>(
    R.layout.fragment_login
) {

//    override val vm: LoginViewModel by activityViewModels {
//        LoginViewModelFactory(
//            (activity?.application as PoeleApplication).database.userDao(),
//        )
//    }
    override val vm: LoginViewModel by viewModels<LoginViewModel>()

    private val args: LoginFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("umutcan", "email: ${args.email}")
        binding.apply {
            viewModel = vm

            if (!args.email.isNullOrEmpty()) {
                vm.getAllUsers().observe(this@LoginFragment.viewLifecycleOwner) {
                    Log.i("umutcan", "user: ${it.size}")
                    textUsername.editText?.setText(it.first().email)
                }
            }
            else {
                textUsername.editText?.setText(args.email)
            }

//            buttonLogin.setOnClickListener {
//                vm.getUserId(textUsername.editText?.text.toString()).observe(this@LoginFragment.viewLifecycleOwner) { list ->
//                    list.firstOrNull()?.let { user ->
//                        Toast.makeText(context, "${user.id} is the id", Toast.LENGTH_LONG).show()
//                        AccountInfo.accountUserId = user.id
//                        SelectedUser.userId = user.id
//                        vm.onLoginClicked()
//                    }
//                }
//            }

            buttonLogin.setOnClickListener {
                vm.email.value = textUsername.editText?.text.toString()
                vm.password.value = textPassword.editText?.text.toString()

                vm.onLoginClicked()
            }

            deneme.setOnClickListener{
                vm.onGuestClicked()
            }
        }
    }
}

object AccountInfo {

    var accountUserId: Int = 0
}
