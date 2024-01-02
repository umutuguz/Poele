package com.umut.poele.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.umut.poele.data.service.AccountService
import com.umut.poele.data.source.local.entity.UserEntity
import com.umut.poele.data.source.local.dao.UserDao
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.AddressListener
import com.umut.poele.util.EditProfileListener
import com.umut.poele.util.FavoritesListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileFirstViewModel @Inject constructor(private val userDao: UserDao, private val accountService: AccountService) : BaseViewModel(),
    FavoritesListener,
    EditProfileListener,
    AddressListener {

    fun getUserWithUserId(userId: Int): LiveData<UserEntity> = userDao.getUserWithUserId(userId).asLiveData()

    override fun onFavoritesClicked() {
        navigate(ProfileFirstFragmentDirections.actionProfileFirstFragmentToFavoriteFragment())
    }

    override fun onAddressClicked() {
        navigate(ProfileFirstFragmentDirections.actionProfileFirstFragmentToAddressFragment())
    }

    override fun onEditProfileClicked() {
        navigate(ProfileFirstFragmentDirections.actionProfileFirstFragmentToEditProfileFragment())
    }

    fun onLogOutClicked() {
        launchCatching {
            accountService.signOut()
            navigate(ProfileFirstFragmentDirections.actionProfileFirstFragmentToLoginFragment())
        }
    }
}

//class ProfileFirstViewModelFactory(
//    private val userDao: UserDao
//) : ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(ProfileFirstViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST") return ProfileFirstViewModel(userDao) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}
