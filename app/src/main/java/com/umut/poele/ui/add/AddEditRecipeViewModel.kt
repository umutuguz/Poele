package com.umut.poele.ui.add

import com.umut.poele.domain.model.RecipeModel
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.CancelListener
import com.umut.poele.util.MacroMealEntryRecipeListener
import com.umut.poele.util.RecipeListener

class AddEditRecipeViewModel : BaseViewModel(), CancelListener , RecipeListener, MacroMealEntryRecipeListener {


    override fun onRecipeClicked(clickedRecipeModel: RecipeModel) {
        navigate(EditRecipeFragmentDirections.actionEditRecipeFragmentToAddEditRecipeFragment(true,clickedRecipeModel))
    }

    override fun onCancelClicked() {
        navigate(AddEditRecipeFragmentDirections.actionAddEditRecipeFragmentToHomeFirstFragment())
    }

    override fun onMacroMealEntryRecipeClicked() {
        navigate(EditRecipeFragmentDirections.actionEditRecipeFragmentToMacroFirstFragment())
    }

    fun onBackClicked(){
        navigateBack()
    }
}
