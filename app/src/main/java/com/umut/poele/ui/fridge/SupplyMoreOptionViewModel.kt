package com.umut.poele.ui.fridge

import com.umut.poele.domain.model.CategoryList
import com.umut.poele.domain.model.Supply
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.AddMacroListener
import com.umut.poele.util.EditSupplyListener
import com.umut.poele.util.EditSupplyMoreOptionListener
import com.umut.poele.util.FindRecipeListener

class SupplyMoreOptionViewModel : BaseViewModel(), FindRecipeListener, AddMacroListener, EditSupplyMoreOptionListener {

    fun onBackClicked(){
        navigateBack()
    }

    override fun onEditSupplyMoreOptionClicked(clickedSupply: Supply) {
        navigate(SupplyMoreOptionDialogDirections.actionSupplyMoreOptionDialogToAddEditSupplyFragment(true, clickedSupply))
    }

    override fun onAddMacroClicked() {
        navigate(SupplyMoreOptionDialogDirections.actionSupplyMoreOptionDialogToFridgeFirstFragment())
    }

    override fun onFindRecipeClicked() {
        // TODO: Fix clickedMealIndex
        navigate(SupplyMoreOptionDialogDirections.actionSupplyMoreOptionDialogToHomeRecipeFragment(0,
            emptyList<CategoryList>().toTypedArray()))
    }
}
