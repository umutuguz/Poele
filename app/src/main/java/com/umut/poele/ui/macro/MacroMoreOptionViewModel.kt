package com.umut.poele.ui.macro

import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.AddSupplyListener

class MacroMoreOptionViewModel : BaseViewModel(), AddSupplyListener {

    fun onBackClicked(){
        navigateBack()
    }

    override fun onAddSupplyClicked() {
        navigate(MacroMoreOptionDialogDirections.actionMacroMoreOptionDialogToAddEditSupplyFragment())
    }
}
