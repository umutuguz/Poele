package com.umut.poele.ui.profile

import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.AddressListener
import com.umut.poele.util.EditProfileListener
import com.umut.poele.util.FavoritesListener
import java.util.PrimitiveIterator

class ProfileFirstViewModel : BaseViewModel(), FavoritesListener, EditProfileListener, AddressListener {

    override fun onFavoritesClicked() {
        navigate(ProfileFirstFragmentDirections.actionProfileFirstFragmentToFavoriteFragment())
    }

    override fun onAddressClicked() {
        navigate(ProfileFirstFragmentDirections.actionProfileFirstFragmentToAddressFragment())
    }

    override fun onEditProfileClicked() {
        navigate(ProfileFirstFragmentDirections.actionProfileFirstFragmentToEditProfileFragment())
    }
}
