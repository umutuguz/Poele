package com.umut.poele.util

import com.umut.poele.domain.model.MealCategory
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.domain.model.Supply

interface RecipeCategoryListener {

    fun onMealCategoryClicked(clickedMealCategory: MealCategory)
}

interface RecipeListener {

    fun onRecipeClicked(clickedRecipe: RecipeBasic)
}

interface SurpriseMeListener {

    fun onSurpriseMeClicked()
}

interface SupplyListener {

    fun onSupplyClicked(clickedSupply: Supply)
}

interface ChooseHomeListener {

    fun onChooseHomeClicked()
}

interface ChooseChefListener {

    fun onChooseChefClicked()
}

interface SearchBarListener {

    fun onSearchBarClicked()
}

interface FilterListener {

    fun onFilterClicked()
}

interface ShopListListener {

    fun onShopListClicked()
}

interface AddRecipeListener {

    fun onAddRecipeClicked()
}

interface EditRecipeListener {

    fun onEditRecipeClicked()
}

interface AddSupplyListener {

    fun onAddSupplyClicked()
}

interface EditSupplyMacroListener {

    fun onEditSupplyMacroClicked(clickedSupply: Supply)
}

interface EditSupplyListener {

    fun onEditSupplyClicked()
}

interface EditSupplyMoreOptionListener {

    fun onEditSupplyMoreOptionClicked(clickedSupply: Supply)
}

interface AddMealListener {

    fun onAddMealClicked()
}

interface ChallengeListener {

    fun onChallengeClicked()
}

interface CancelListener {

    fun onCancelClicked()
}

interface AddShopListListener {

    fun onAddShopListClicked()
}

interface EnterDailyMenuListener {

    fun onEnterDailyMenuClicked()
}

interface AddMacroListener {

    fun onAddMacroClicked()
}

interface FindRecipeListener {

    fun onFindRecipeClicked()
}

interface MoreOptionListener {

    fun onMoreOptionClicked(clickedSupply: Supply)
}

interface AddFromRecipeListener {

    fun onAddFromRecipeClicked()
}

interface AddFromSupplyListener {

    fun onAddFromSupplyClicked()
}

interface AddCustomMealListener {

    fun onAddCustomMealClicked()
}

interface FavoritesListener {

    fun onFavoritesClicked()
}

interface ListSelectionsListener {

    fun onListSelectionsClicked()
}

interface AddressListener {

    fun onAddressClicked()
}

interface EditProfileListener {

    fun onEditProfileClicked()
}

interface MacroMealEntrySupplyListener {

    fun onMacroMealEntrySupplyClicked()
}

interface MacroMealEntryRecipeListener {

    fun onMacroMealEntryRecipeClicked()
}

interface UserLoginListener {

    fun onLoginClicked()
    fun onSignUpClicked()
    fun onGuestLoginClicked()

}

interface UserSignupListener {

    fun onSignupClicked(email: String)

}
