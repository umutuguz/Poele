package com.umut.poele.ui.supply

import com.umut.poele.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FridgeSupplyViewModel @Inject constructor() : BaseViewModel() {

    fun onBackClicked() {
        navigate(FridgeSupplyFragmentDirections.actionFridgeSupplyFragmentToFridgeFirstFragment())
    }
}
