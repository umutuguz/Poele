package com.umut.poele.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.umut.poele.data.source.local.entity.UserEntity
import com.umut.poele.data.source.local.dao.UserDao
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.UserLoginListener

class LoginViewModel(
    private val userDao: UserDao
) : BaseViewModel(), UserLoginListener  {

    fun getUserId(userEmail: String): LiveData<List<UserEntity>> = userDao.getUserWithUserEmail(userEmail).asLiveData()

    fun getAllUsers(): LiveData<List<UserEntity>> = userDao.getAllUsers().asLiveData()

    override fun onLoginClicked() {
        navigate(LoginFragmentDirections.actionLoginFragmentToHomeFirstFragment())
    }

    override fun onSignUpClicked() {

    }

    override fun onGuestLoginClicked() {
        LoginFragmentDirections.actionLoginFragmentToHomeFirstFragment()
    }
}


class LoginViewModelFactory(
    private val userDao: UserDao,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return LoginViewModel(userDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
