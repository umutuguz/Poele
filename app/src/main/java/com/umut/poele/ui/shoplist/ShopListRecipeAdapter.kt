package com.umut.poele.ui.shoplist

import com.umut.poele.R
import com.umut.poele.databinding.ListShopListRecipeBinding
import com.umut.poele.model.RecipeModel
import com.umut.poele.ui.base.BaseAdapter

class ShopListRecipeAdapter(private val dataset: List<RecipeModel>) :
    BaseAdapter<ListShopListRecipeBinding, RecipeModel>(dataset, R.layout.list_shop_list_recipe) {

    override fun bind(binding: ListShopListRecipeBinding, item: RecipeModel) {
        binding.apply {
            recipeModel = item
        }
    }
}
