package com.umut.poele.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.umut.poele.data.service.AccountService
import com.umut.poele.data.source.local.entity.UserEntity
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.UserLoginListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val accountService: AccountService
) : BaseViewModel(), UserLoginListener  {

    val email = MutableStateFlow("")
    val password = MutableStateFlow("")
    private val _recipeList = MutableLiveData<RecipeBasic>()

    val recipeList : LiveData<RecipeBasic> = _recipeList

    private val _recipeInfo = MutableLiveData<RecipeBasic>()

    val recipeInfo : LiveData<RecipeBasic> = _recipeInfo

    override fun onLoginClicked() {
        launchCatching{
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
