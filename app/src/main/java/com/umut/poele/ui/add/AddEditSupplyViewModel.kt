package com.umut.poele.ui.add

import com.umut.poele.model.Supply
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.CancelListener
import com.umut.poele.util.SupplyListener

class AddEditSupplyViewModel : BaseViewModel(), CancelListener, SupplyListener {

    override fun onSupplyClicked(clickedSupply: Supply) {
        navigate(EditSupplyFragmentDirections.actionEditSupplyFragmentToAddEditSupplyFragment())
    }

    override fun onCancelClicked() {
        navigate(AddEditSupplyFragmentDirections.actionAddEditSupplyFragmentToFridgeFirstFragment())
    }

    fun onBackClicked(){
        navigateBack()
    }
}
