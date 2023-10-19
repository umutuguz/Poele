package com.umut.poele.ui.shoplist

import com.umut.poele.R
import com.umut.poele.databinding.ListShopListRecipeBinding
import com.umut.poele.model.Recipe
import com.umut.poele.ui.base.BaseAdapter

class ShopListRecipeAdapter(private val dataset: List<Recipe>) :
    BaseAdapter<ListShopListRecipeBinding, Recipe>(dataset, R.layout.list_shop_list_recipe) {

    override fun bind(binding: ListShopListRecipeBinding, item: Recipe) {
        binding.apply {
            recipe = item
        }
    }
}
