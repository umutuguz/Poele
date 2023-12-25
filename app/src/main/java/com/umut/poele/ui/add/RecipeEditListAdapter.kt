package com.umut.poele.ui.add

import com.umut.poele.R
import com.umut.poele.databinding.ListEditRecipeBinding
import com.umut.poele.domain.model.RecipeModel
import com.umut.poele.ui.base.BaseAdapter

class RecipeEditListAdapter(private val dataset: List<RecipeModel>, private val vm: AddEditRecipeViewModel, private val forPickRecipe: Boolean) :
    BaseAdapter<ListEditRecipeBinding,
            RecipeModel>(dataset, R
    .layout
    .list_edit_recipe) {

    override fun bind(binding: ListEditRecipeBinding, item: RecipeModel) {
        binding.apply {
            recipeModel = item
            viewModel = vm

            if (forPickRecipe) {
                cardRecipe.setOnClickListener {
                    vm.onMacroMealEntryRecipeClicked()
                }
            }else {
                cardRecipe.setOnClickListener {
                    vm.onRecipeClicked(item)
                }
            }
        }
    }
}
