package com.umut.poele.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.umut.poele.database.address.AddressDao
import com.umut.poele.database.category.RecipeCategoryDao
import com.umut.poele.database.menu.MenuCardDao
import com.umut.poele.database.user.User
import com.umut.poele.database.user.UserDao
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.ui.home.HomeFirstViewModel
import com.umut.poele.util.UserLoginListener
import kotlinx.coroutines.flow.Flow

class LoginViewModel(
    private val userDao: UserDao
) : BaseViewModel(), UserLoginListener  {

    fun getUserId(userEmail: String): LiveData<List<User>> = userDao.getUserWithUserEmail(userEmail).asLiveData()

    fun getAllUsers(): LiveData<List<User>> = userDao.getAllUsers().asLiveData()

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
