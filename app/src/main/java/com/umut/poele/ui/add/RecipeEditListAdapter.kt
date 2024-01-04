package com.umut.poele.ui.add

import com.umut.poele.R
import com.umut.poele.databinding.ListEditRecipeBinding
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.ui.base.BaseAdapter

class RecipeEditListAdapter(private val dataset: List<RecipeBasic>, private val vm: AddEditRecipeViewModel, private val forPickRecipe: Boolean) :
    BaseAdapter<ListEditRecipeBinding,
            RecipeBasic>(dataset, R
    .layout
    .list_edit_recipe) {

    override fun bind(binding: ListEditRecipeBinding, item: RecipeBasic) {
        binding.apply {
            recipe = item
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
