package com.umut.poele.ui.add

import android.view.View
import com.umut.poele.R
import com.umut.poele.databinding.ListEditRecipeBinding
import com.umut.poele.databinding.ListRecipeBinding
import com.umut.poele.model.Recipe
import com.umut.poele.ui.base.BaseAdapter

class RecipeEditListAdapter(private val dataset: List<Recipe>, private val vm: AddEditRecipeViewModel) : BaseAdapter<ListEditRecipeBinding, Recipe>(dataset, R
    .layout
    .list_edit_recipe) {

    override fun bind(binding: ListEditRecipeBinding, item: Recipe) {
        binding.apply {
            recipe = item
            viewModel = vm
        }
    }
}
