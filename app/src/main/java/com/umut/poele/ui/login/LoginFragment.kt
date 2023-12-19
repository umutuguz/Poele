package com.umut.poele.ui.login

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.umut.PoeleApplication
import com.umut.poele.R
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.databinding.FragmentLoginBinding
import com.umut.poele.ui.choose.SelectedUser

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>(
    R.layout.fragment_login
) {

    override val vm: LoginViewModel by activityViewModels {
        LoginViewModelFactory(
            (activity?.application as PoeleApplication).database.userDao()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            vm.getAllUsers().observe(this@LoginFragment.viewLifecycleOwner) {
                Log.i("umutcan", "user: ${it.size}")
                textUsername.editText?.setText(it.first().email)
            }

            buttonLogin.setOnClickListener {
                vm.getUserId(textUsername.editText?.text.toString()).observe(this@LoginFragment.viewLifecycleOwner) { list ->
                    list.firstOrNull()?.let { user ->
                        Toast.makeText(context, "${user.id} is the id", Toast.LENGTH_LONG).show()
                        AccountInfo.accountUserId = user.id
                        SelectedUser.userId = user.id
                        vm.onLoginClicked()
                    }
                }
            }
        }
    }
}

object AccountInfo {

    var accountUserId: Int = 0
}
