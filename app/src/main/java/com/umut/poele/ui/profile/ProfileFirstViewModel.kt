package com.umut.poele.ui.profile

import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.FavoritesListener

class ProfileFirstViewModel : BaseViewModel(), FavoritesListener {

    override fun onFavoritesClicked() {
        navigate(ProfileFirstFragmentDirections.actionProfileFirstFragmentToFavoriteFragment())
    }
}
