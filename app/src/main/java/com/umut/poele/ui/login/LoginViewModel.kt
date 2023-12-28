package com.umut.poele.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.umut.poele.data.service.AccountService
import com.umut.poele.data.source.local.entity.UserEntity
import com.umut.poele.data.source.local.dao.UserDao
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.UserLoginListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userDao: UserDao,
    private val accountService: AccountService
) : BaseViewModel(), UserLoginListener  {

    val email = MutableStateFlow("")
    val password = MutableStateFlow("")

    fun getUserId(userEmail: String): LiveData<List<UserEntity>> = userDao.getUserWithUserEmail(userEmail).asLiveData()

    fun getAllUsers(): LiveData<List<UserEntity>> = userDao.getAllUsers().asLiveData()

    override fun onLoginClicked() {
        Log.i("umutcan", "onLoginClicked")
        launchCatching{
            Log.i("umutcan", "launchCatching")
            Log.i("umutcan", "email: ${email.value} \npassword: ${password.value}")
            accountService.signIn(email.value, password.value)
            navigate(LoginFragmentDirections.actionLoginFragmentToHomeFirstFragment())
        }
    }

    fun onGuestClicked(){
        launchCatching {
            accountService.signOut()
        }
    }

    override fun onSignUpClicked() {
        navigate(LoginFragmentDirections.actionLoginFragmentToSignupFragment())
    }

    override fun onGuestLoginClicked() {
        LoginFragmentDirections.actionLoginFragmentToHomeFirstFragment()
    }

}


//class LoginViewModelFactory(
//    private val userDao: UserDao,
//    private val accountService: AccountService
//) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST") return LoginViewModel(userDao, accountService) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}
