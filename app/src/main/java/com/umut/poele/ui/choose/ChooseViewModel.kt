package com.umut.poele.ui.choose

import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.ListSelectionsListener

class ChooseViewModel : BaseViewModel(),  ListSelectionsListener{

    fun onBackClicked() {
        navigateBack()
    }

    override fun onListSelectionsClicked() {
        navigateBack()
    }
}
