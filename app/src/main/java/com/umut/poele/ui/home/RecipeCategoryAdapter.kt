package com.umut.poele.ui.home

import com.umut.poele.R
import com.umut.poele.databinding.ListRecipeCategoryBinding
import com.umut.poele.domain.model.MealCategory
import com.umut.poele.ui.base.BaseAdapter
import com.umut.poele.util.RecipeCategoryListener

class RecipeCategoryAdapter(private val dataset: List<MealCategory>,
                            private val recipeCategoryClickListener: RecipeCategoryListener,
                            private val vm: HomeFirstViewModel
) :
    BaseAdapter<ListRecipeCategoryBinding,
            MealCategory>
    (dataset, R.layout.list_recipe_category) {

    override fun bind(binding: ListRecipeCategoryBinding, item: MealCategory) {
        binding.apply {
            mealCategory = item
            listener = recipeCategoryClickListener
            viewModel = vm
        }
    }
}
