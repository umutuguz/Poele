package com.umut.poele.ui.add

import com.umut.poele.model.Supply
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.CancelListener
import com.umut.poele.util.MacroMealEntrySupplyListener
import com.umut.poele.util.SupplyListener

class AddEditSupplyViewModel : BaseViewModel(), CancelListener, SupplyListener, MacroMealEntrySupplyListener {

    override fun onSupplyClicked(clickedSupply: Supply) {
        navigate(EditSupplyFragmentDirections.actionEditSupplyFragmentToAddEditSupplyFragment(true, clickedSupply))
    }

    override fun onCancelClicked() {
        navigate(AddEditSupplyFragmentDirections.actionAddEditSupplyFragmentToFridgeFirstFragment())
    }

    override fun onMacroMealEntrySupplyClicked() {
        navigate(EditSupplyFragmentDirections.actionEditSupplyFragmentToMacroFirstFragment())
    }

    fun onBackClicked() {
        navigateBack()
    }
}
