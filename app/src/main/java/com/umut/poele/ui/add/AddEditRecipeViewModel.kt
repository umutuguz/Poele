package com.umut.poele.ui.add

import com.umut.poele.model.Recipe
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.CancelListener
import com.umut.poele.util.EditRecipeListener
import com.umut.poele.util.RecipeListener

class AddEditRecipeViewModel : BaseViewModel(), CancelListener , RecipeListener {


    override fun onRecipeClicked(clickedRecipe: Recipe) {
        navigate(EditRecipeFragmentDirections.actionEditRecipeFragmentToAddEditRecipeFragment())
    }

    override fun onCancelClicked() {
        navigate(AddEditRecipeFragmentDirections.actionAddEditRecipeFragmentToHomeFirstFragment())
    }

    fun onBackClicked(){
        navigateBack()
    }
}
