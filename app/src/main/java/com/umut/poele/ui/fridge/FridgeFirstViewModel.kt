package com.umut.poele.ui.fridge

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.android.play.integrity.internal.w
import com.umut.poele.data.source.local.dao.SupplyDao
import com.umut.poele.domain.model.Supply
import com.umut.poele.domain.use_case.GetSuppliesUseCase
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.ui.choose.SelectedUser
import com.umut.poele.util.ChooseHomeListener
import com.umut.poele.util.FilterListener
import com.umut.poele.util.MoreOptionListener
import com.umut.poele.util.Resource
import com.umut.poele.util.SearchBarListener
import com.umut.poele.util.ShopListListener
import com.umut.poele.util.States
import com.umut.poele.util.SurpriseMeListener
import com.umut.poele.util.Units
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class FridgeFirstViewModel @Inject constructor(private val getSuppliesUseCase: GetSuppliesUseCase)
    : BaseViewModel(), SurpriseMeListener, SearchBarListener,
    FilterListener,
    ChooseHomeListener,
    ShopListListener, MoreOptionListener {

        private val _supplyListLiveData = MutableLiveData<List<Supply>>()
    val supplyListLiveData get() = _supplyListLiveData

    init {
        getSuppliesWithUserId(SelectedUser.userId)
    }

    private fun getSuppliesWithUserId(userId: Int) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) { getSuppliesUseCase.getSuppliesWithUserId(userId)}

            result.data?.let {list->
                list.forEach { supply->
                    val result2 = withContext(Dispatchers.IO){getSuppliesUseCase.getAmountWithSupplyId(supply.id)}
                    supply.amount = result2.data?.amount ?: 0.0
                    supply.date = result2.data?.date ?: LocalDate.now()
                    supply.unit = result2.data?.unit ?: Units.UNDETERMINED
                    supply.state = result2.data?.state ?: States.UNDETERMINED
                    supply.amountId = result2.data?.amountId ?: 0
                }
                _supplyListLiveData.value = list
            }
        }
    }

    fun deleteSupplyFromFridge(amountId: Int, userId: Int) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {getSuppliesUseCase.deleteSupplyFromFridge(amountId, userId)}
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
