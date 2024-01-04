package com.umut.poele.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.umut.poele.data.service.AccountService
import com.umut.poele.data.source.local.entity.UserEntity
import com.umut.poele.data.source.local.dao.UserDao
import com.umut.poele.data.source.remote.dto.UserDto
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

        private val _profileInfoLiveData = MutableLiveData<UserDto>()
    val profileInfoLiveData get() = _profileInfoLiveData

    init {
//        accountInfo()
    }

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

//    fun accountInfo() {
//        launchCatching {
//            accountService.currentUser.collect(){
//                _profileInfoLiveData.value = it
//            }
//        }
//    }
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
