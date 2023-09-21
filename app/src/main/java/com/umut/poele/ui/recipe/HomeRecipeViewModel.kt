package com.umut.poele.ui.recipe

import com.umut.poele.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeRecipeViewModel @Inject constructor() : BaseViewModel() {
    fun goBackClicked() {
        navigateBack()
    }
}
