package com.umut.poele.ui.macro

import com.umut.poele.model.Supply
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.AddSupplyListener
import com.umut.poele.util.EditSupplyMacroListener

class MacroMoreOptionViewModel : BaseViewModel(), EditSupplyMacroListener {

    fun onBackClicked(){
        navigateBack()
    }

    override fun onEditSupplyMacroClicked(clickedSupply: Supply) {
        navigate(MacroMoreOptionDialogDirections.actionMacroMoreOptionDialogToAddEditSupplyFragment(true, clickedSupply))
    }
}
