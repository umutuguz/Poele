package com.umut.poele.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.umut.poele.data.service.AccountService
import com.umut.poele.data.source.local.entity.UserEntity
import com.umut.poele.data.source.local.dao.UserDao
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.domain.use_case.GetMemesUseCase
import com.umut.poele.domain.use_case.GetRecipesUseCase
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.UserLoginListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userDao: UserDao,
    private val accountService: AccountService,
    private val getMemesUseCase: GetMemesUseCase,
    private val getRecipesUseCase: GetRecipesUseCase,
) : BaseViewModel(), UserLoginListener  {

    val email = MutableStateFlow("")
    val password = MutableStateFlow("")
    private val _recipeList = MutableLiveData<RecipeBasic>()

    val recipeList : LiveData<RecipeBasic> = _recipeList

    private val _recipeInfo = MutableLiveData<RecipeBasic>()

    val recipeInfo : LiveData<RecipeBasic> = _recipeInfo

    fun getUserId(userEmail: String): LiveData<List<UserEntity>> = userDao.getUserWithUserEmail(userEmail).asLiveData()

    fun getAllUsers(): LiveData<List<UserEntity>> = userDao.getAllUsers().asLiveData()

    override fun onLoginClicked() {
        launchCatching{
            accountService.signIn(email.value, password.value)
            navigate(LoginFragmentDirections.actionLoginFragmentToHomeFirstFragment())
        }
    }
    init {
//        getRecipes()
//        getRecipeInfo(recipeList.value?.id ?: 716429, true)
    }
    fun onGuestClicked(){
        launchCatching {
            accountService.signOut()
        }
    }

//    private fun getMemes() {
//        viewModelScope.launch {
//            val result = withContext(Dispatchers.IO) { getMemesUseCase.getMemes() }
//            _memeList.value = result.data?.first() ?: Meme("","","")
//        }
//    }



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
