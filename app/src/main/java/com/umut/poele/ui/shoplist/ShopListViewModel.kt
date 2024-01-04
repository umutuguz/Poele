package com.umut.poele.ui.shoplist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.domain.use_case.GetRecipesUseCase
import com.umut.poele.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ShopListViewModel @Inject constructor(private val getRecipesUseCase: GetRecipesUseCase): BaseViewModel() {

    private val _shopListLiveData = MutableLiveData<List<RecipeBasic>>()
    val shopListLiveData get() = _shopListLiveData

    fun onBackClicked(){
        navigateBack()
    }

    init {
        getShopList()
    }

    private fun getShopList() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) { getRecipesUseCase.getShopList() }
            result.data?.let {
                _shopListLiveData.value = it
            }
        }
    }

    fun deleteAllShopList() {
        viewModelScope.launch{
            getRecipesUseCase.deleteShopList()
        }
    }

}
