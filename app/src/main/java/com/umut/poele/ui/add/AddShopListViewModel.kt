package com.umut.poele.ui.add

import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.CancelListener

class AddShopListViewModel : BaseViewModel(), CancelListener {

    fun onBackClicked(){
        navigateBack()
    }

    override fun onCancelClicked() {
        navigate(AddShopListFragmentDirections.actionAddShopListFragmentToHomeFirstFragment())
    }
}
