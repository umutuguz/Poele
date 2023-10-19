package com.umut.poele.ui.add

import android.util.Log
import com.umut.poele.model.Recipe
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.ui.home.HomeFirstFragmentDirections
import com.umut.poele.util.AddRecipeListener
import com.umut.poele.util.AddShopListListener
import com.umut.poele.util.AddSupplyListener
import com.umut.poele.util.CancelListener
import com.umut.poele.util.EditRecipeListener
import com.umut.poele.util.EditSupplyListener
import com.umut.poele.util.EnterDailyMenuListener
import com.umut.poele.util.RecipeListener

class AddViewModel : BaseViewModel(), AddRecipeListener, EditRecipeListener, AddSupplyListener, EditSupplyListener,AddShopListListener, EnterDailyMenuListener  {

    fun onBackClicked(){
        navigateBack()
    }

    override fun onAddRecipeClicked() {
        navigate(AddFragmentDirections.actionAddFragmentToAddEditRecipeFragment())
    }

    override fun onEditRecipeClicked() {
        navigate(AddFragmentDirections.actionAddFragmentToEditRecipeFragment())
    }

    override fun onAddSupplyClicked() {
        navigate(AddFragmentDirections.actionAddFragmentToAddEditSupplyFragment())
    }

    override fun onEditSupplyClicked() {
        navigate(AddFragmentDirections.actionAddFragmentToEditSupplyFragment())
    }

    override fun onAddShopListClicked() {
        navigate(AddFragmentDirections.actionAddFragmentToAddShopListFragment())
    }

    override fun onEnterDailyMenuClicked() {
        navigate(AddFragmentDirections.actionAddFragmentToDailyMenuFragment())
    }
}
