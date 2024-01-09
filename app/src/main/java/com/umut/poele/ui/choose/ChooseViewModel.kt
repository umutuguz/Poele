package com.umut.poele.ui.choose

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.umut.poele.data.source.local.entity.UserEntity
import com.umut.poele.data.source.local.dao.UserDao
import com.umut.poele.data.source.local.relation.UserWithAddresses
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.ListSelectionsListener

class ChooseViewModel(private val userDao: UserDao) : BaseViewModel(),  ListSelectionsListener{

    fun getAllUsers(): LiveData<List<UserEntity>> = userDao.getAllUsers().asLiveData()

    fun getAllAddressesWithUser(userId: Int): LiveData<List<UserWithAddresses>>{
        return userDao.getAddressesWithUserId(userId).asLiveData()
    }


    fun onBackClicked() {
        navigateBack()
    }

    override fun onListSelectionsClicked() {
        navigateBack()
    }
}

class ChooseViewModelFactory(
    private val userDao: UserDao,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChooseViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return ChooseViewModel(userDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
