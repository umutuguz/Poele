package com.umut.poele.ui.fridge

import com.umut.poele.model.Supply
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.ChooseHomeListener
import com.umut.poele.util.FilterListener
import com.umut.poele.util.MoreOptionListener
import com.umut.poele.util.SearchBarListener
import com.umut.poele.util.ShopListListener
import com.umut.poele.util.SurpriseMeListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FridgeFirstViewModel @Inject constructor() : BaseViewModel(), SurpriseMeListener, SearchBarListener, FilterListener, ChooseHomeListener,
    ShopListListener, MoreOptionListener{

    override fun onSurpriseMeClicked() {
        navigate(FridgeFirstFragmentDirections.actionFridgeFirstFragmentToFridgeSupplyFragment())
    }

    override fun onSearchBarClicked() {
        navigate(FridgeFirstFragmentDirections.actionFridgeFirstFragmentToSearchFragment())
    }

    override fun onFilterClicked() {
        navigate(FridgeFirstFragmentDirections.actionFridgeFirstFragmentToFilterDialog(), true)
    }

    override fun onChooseHomeClicked() {
        navigate(FridgeFirstFragmentDirections.actionFridgeFirstFragmentToChooseHomeDialog(), true)
    }

    override fun onShopListClicked() {
        navigate(FridgeFirstFragmentDirections.actionFridgeFirstFragmentToShopListFragment())
    }

    override fun onMoreOptionClicked(clickedSupply: Supply) {
        navigate(FridgeFirstFragmentDirections.actionFridgeFirstFragmentToSupplyMoreOptionDialog())
    }
}
