package com.umut.poele.ui.home

import com.umut.poele.R
import com.umut.poele.databinding.ListRecipeCategoryBinding
import com.umut.poele.model.FoodCategory
import com.umut.poele.ui.base.BaseAdapter
import com.umut.poele.util.FoodCategoryListener

class FoodCategoryAdapter(private val dataset: List<FoodCategory>,
    private val foodCategoryClickListener: FoodCategoryListener
) :
    BaseAdapter<ListRecipeCategoryBinding,
        FoodCategory>
    (dataset, R.layout.list_recipe_category) {

    override fun bind(binding: ListRecipeCategoryBinding, item: FoodCategory) {
        binding.apply {
            foodCategory = item
            listener = foodCategoryClickListener
            viewModel = HomeFirstViewModel()
        }
    }
}
