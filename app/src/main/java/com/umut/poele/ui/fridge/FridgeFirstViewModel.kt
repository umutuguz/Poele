package com.umut.poele.ui.fridge

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.umut.poele.domain.model.Supply
import com.umut.poele.domain.use_case.GetSuppliesUseCase
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.ui.choose.SelectedUser
import com.umut.poele.util.ChooseHomeListener
import com.umut.poele.util.FilterListener
import com.umut.poele.util.MoreOptionListener
import com.umut.poele.util.SearchBarListener
import com.umut.poele.util.ShopListListener
import com.umut.poele.util.SurpriseMeListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FridgeFirstViewModel @Inject constructor(
    private val getSuppliesUseCase: GetSuppliesUseCase
) : BaseViewModel(), SurpriseMeListener,
    SearchBarListener, FilterListener,
    ChooseHomeListener, ShopListListener, MoreOptionListener {

    private val _supplyListLiveData = MutableLiveData<List<Supply>>()
    val supplyListLiveData get() = _supplyListLiveData

    init {
        getSuppliesWithUserId(SelectedUser.userId)
    }

    private fun getSuppliesWithUserId(userId: Int) {
        viewModelScope.launch {
            val supplyResult = withContext(Dispatchers.IO) { getSuppliesUseCase.getSuppliesWithUserId(userId) }
            val supplyList = mutableListOf<Supply>()

            supplyResult.data?.let { list ->
                list.forEach { supply ->
                    val amountResult = withContext(Dispatchers.IO) {
                        getSuppliesUseCase.getAmountWithSupplyId(supply.id)
                    }

                    amountResult.data?.let {
                        if (it.userId == SelectedUser.userId) {
                            supply.amount = amountResult.data.amount
                            supply.date = amountResult.data.date
                            supply.unit = amountResult.data.unit
                            supply.state = amountResult.data.state
                            supply.amountId = amountResult.data.amountId
                            supplyList.add(supply)
                        }
                    }
                }
            }
            _supplyListLiveData.value = supplyList
        }
    }

    fun deleteSupplyFromFridge(amountId: Int, userId: Int) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) { getSuppliesUseCase.deleteSupplyFromFridge(amountId, userId) }
            result.data?.let {
                _supplyListLiveData.value = it
            }
        }
    }

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
