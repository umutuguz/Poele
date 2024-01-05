package com.umut.poele.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.umut.poele.domain.model.MealCategory
import com.umut.poele.domain.model.MenuCard
import com.umut.poele.domain.use_case.GetMenuCardUseCase
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.ChooseChefListener
import com.umut.poele.util.ChooseHomeListener
import com.umut.poele.util.MealTypes
import com.umut.poele.util.RecipeCategoryListener
import com.umut.poele.util.SearchBarListener
import com.umut.poele.util.ShopListListener
import com.umut.poele.util.toMealCategoryList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeFirstViewModel @Inject constructor(
    private val getMenuCardUseCase: GetMenuCardUseCase
) : BaseViewModel(), RecipeCategoryListener, ChooseHomeListener,
    ChooseChefListener, SearchBarListener, ShopListListener
{

    private val _menuCardListLiveData = MutableLiveData<List<MenuCard>>()
    val menuCardListLiveData get() = _menuCardListLiveData

    init {
        getMenuCardInfo("Umut", "week", 2000)
    }

    private fun getMenuCardInfo(userName: String, timeFrame: String, targetCalorie: Int) {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                getMenuCardUseCase.getMenuCard(userName, timeFrame, targetCalorie)
            }
            result.data?.let {
                _menuCardListLiveData.value = it
            }
        }
    }
    fun getMealTypes(): List<MealCategory> = MealTypes.MAINCOURSE.toMealCategoryList()

    override fun onMealCategoryClicked(clickedMealCategory: MealCategory) {
        navigate(HomeFirstFragmentDirections.actionHomeFirstFragmentToHomeRecipeFragment(clickedMealCategory))
    }

    override fun onChooseHomeClicked() {
        navigate(HomeFirstFragmentDirections.actionHomeFirstFragmentToChooseHomeDialog(), true)
    }

    override fun onChooseChefClicked() {
        navigate(HomeFirstFragmentDirections.actionHomeFirstFragmentToChooseChefDialog(), true)
    }

    override fun onSearchBarClicked() {
        navigate(HomeFirstFragmentDirections.actionHomeFirstFragmentToSearchFragment())
    }

    override fun onShopListClicked() {
        navigate(HomeFirstFragmentDirections.actionHomeFirstFragmentToShopListFragment())
    }

}
