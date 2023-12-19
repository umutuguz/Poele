package com.umut.poele.ui.home

import com.umut.poele.R
import com.umut.poele.database.category.RecipeCategory
import com.umut.poele.databinding.ListRecipeCategoryBinding
import com.umut.poele.ui.base.BaseAdapter
import com.umut.poele.util.RecipeCategoryListener

class RecipeCategoryAdapter(private val dataset: List<RecipeCategory>,
    private val recipeCategoryClickListener: RecipeCategoryListener,
    private val vm: HomeFirstViewModel
) :
    BaseAdapter<ListRecipeCategoryBinding,
        RecipeCategory>
    (dataset, R.layout.list_recipe_category) {

    override fun bind(binding: ListRecipeCategoryBinding, item: RecipeCategory) {
        binding.apply {
            recipeCategory = item
            listener = recipeCategoryClickListener
            viewModel = vm
        }
    }
}
