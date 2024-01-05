package com.umut.poele.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.umut.poele.data.service.AccountService
import com.umut.poele.data.source.local.entity.UserEntity
import com.umut.poele.data.source.local.dao.UserDao
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.ui.login.LoginViewModel
import com.umut.poele.util.UserLoginListener
import com.umut.poele.util.UserSignupListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val userDao: UserDao,
    private val accountService: AccountService
) : BaseViewModel(), UserSignupListener  {

    val emailState = MutableStateFlow("")
    val password = MutableStateFlow("")

    override fun onSignupClicked(email: String) {
        launchCatching {
            accountService.signUp(emailState.value, password.value)
            navigate(SignupFragmentDirections.actionSignupFragmentToLoginFragment(email))
        }
    }
}
