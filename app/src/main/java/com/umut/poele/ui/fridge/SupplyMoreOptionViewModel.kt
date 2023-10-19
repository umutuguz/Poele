package com.umut.poele.ui.fridge

import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.AddMacroListener
import com.umut.poele.util.EditSupplyListener
import com.umut.poele.util.FindRecipeListener

class SupplyMoreOptionViewModel : BaseViewModel(), FindRecipeListener, AddMacroListener, EditSupplyListener {

    fun onBackClicked(){
        navigateBack()
    }

    override fun onEditSupplyClicked() {
        navigate(SupplyMoreOptionDialogDirections.actionSupplyMoreOptionDialogToAddEditSupplyFragment())
    }

    override fun onAddMacroClicked() {
        navigate(SupplyMoreOptionDialogDirections.actionSupplyMoreOptionDialogToFridgeFirstFragment())
    }

    override fun onFindRecipeClicked() {
        navigate(SupplyMoreOptionDialogDirections.actionSupplyMoreOptionDialogToHomeRecipeFragment())
    }
}
