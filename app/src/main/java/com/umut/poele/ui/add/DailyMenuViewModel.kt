package com.umut.poele.ui.add

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.umut.poele.database.menu.MenuCard
import com.umut.poele.database.recipe.RecipeDao
import com.umut.poele.database.user.UserDao
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.ui.recipe.HomeRecipeViewModel
import com.umut.poele.util.CancelListener
import kotlinx.coroutines.flow.Flow

class DailyMenuViewModel(private val userDao: UserDao) : BaseViewModel(), CancelListener {

    fun getMenuCardWithUserId(userId: Int): Flow<List<MenuCard>> {
        Log.i("umutcan", "Full Address")
        return userDao.getMenuCardWithUserId(userId)
    }

    fun onBackClicked() {
        navigateBack()
    }

    override fun onCancelClicked() {
        navigate(DailyMenuFragmentDirections.actionDailyMenuFragmentToHomeFirstFragment())
    }
}

class DailyMenuViewModelFactory(
    private val userDao: UserDao
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DailyMenuViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return DailyMenuViewModel(userDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
