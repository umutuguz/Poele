package com.umut.poele.ui.home

import com.umut.poele.R
import com.umut.poele.data.source.local.entity.RecipeCategoryEntity
import com.umut.poele.databinding.ListRecipeCategoryBinding
import com.umut.poele.ui.base.BaseAdapter
import com.umut.poele.util.RecipeCategoryListener

class RecipeCategoryAdapter(private val dataset: List<RecipeCategoryEntity>,
                            private val recipeCategoryClickListener: RecipeCategoryListener,
                            private val vm: HomeFirstViewModel
) :
    BaseAdapter<ListRecipeCategoryBinding,
            RecipeCategoryEntity>
    (dataset, R.layout.list_recipe_category) {

    override fun bind(binding: ListRecipeCategoryBinding, item: RecipeCategoryEntity) {
        binding.apply {
            recipeCategory = item
            listener = recipeCategoryClickListener
            viewModel = vm
        }
    }
}
