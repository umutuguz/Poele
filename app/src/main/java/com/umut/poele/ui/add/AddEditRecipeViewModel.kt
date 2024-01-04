package com.umut.poele.ui.add

import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.domain.model.RecipeModel
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.CancelListener
import com.umut.poele.util.MacroMealEntryRecipeListener
import com.umut.poele.util.RecipeListener

class AddEditRecipeViewModel : BaseViewModel(), CancelListener , RecipeListener, MacroMealEntryRecipeListener {


    override fun onRecipeClicked(clickedRecipe: RecipeBasic) {
        navigate(EditRecipeFragmentDirections.actionEditRecipeFragmentToAddEditRecipeFragment(true,clickedRecipe))
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
