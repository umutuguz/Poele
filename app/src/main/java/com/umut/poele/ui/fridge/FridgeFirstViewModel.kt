package com.umut.poele.ui.fridge

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.umut.poele.data.source.local.dao.SupplyDao
import com.umut.poele.domain.model.Supply
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.ChooseHomeListener
import com.umut.poele.util.FilterListener
import com.umut.poele.util.MoreOptionListener
import com.umut.poele.util.SearchBarListener
import com.umut.poele.util.ShopListListener
import com.umut.poele.util.SurpriseMeListener

class FridgeFirstViewModel(private val supplyDao: SupplyDao)  : BaseViewModel(), SurpriseMeListener, SearchBarListener, FilterListener,
    ChooseHomeListener,
    ShopListListener, MoreOptionListener{

//    fun getAllSuppliesWithUserId(userId: Int): LiveData<List<SupplyWithUsers>> = supplyDao.getAllSuppliesWithUserId(userId).asLiveData()

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
        navigate(FridgeFirstFragmentDirections.actionFridgeFirstFragmentToSupplyMoreOptionDialog(clickedSupply))
    }
}

class FridgeFirstViewModelFactory(
    private val supplyDao: SupplyDao
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FridgeFirstViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return FridgeFirstViewModel(supplyDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
