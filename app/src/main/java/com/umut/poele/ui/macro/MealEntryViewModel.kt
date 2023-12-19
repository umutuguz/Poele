package com.umut.poele.ui.macro

import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.AddCustomMealListener
import com.umut.poele.util.AddFromRecipeListener
import com.umut.poele.util.AddFromSupplyListener

class MealEntryViewModel : BaseViewModel(), AddFromRecipeListener, AddFromSupplyListener, AddCustomMealListener {

    fun onBackClicked(){
        navigateBack()
    }

    override fun onAddFromRecipeClicked() {
        navigate(MealEntryDialogDirections.actionMealEntryDialogToEditRecipeFragment(true))
    }

    override fun onAddFromSupplyClicked() {
        navigate(MealEntryDialogDirections.actionMealEntryDialogToEditSupplyFragment(true))
    }

    override fun onAddCustomMealClicked() {
        navigate(MealEntryDialogDirections.actionMealEntryDialogToAddEditSupplyFragment())
    }
}
