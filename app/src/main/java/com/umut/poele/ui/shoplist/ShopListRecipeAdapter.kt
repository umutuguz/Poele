package com.umut.poele.ui.shoplist

import com.umut.poele.R
import com.umut.poele.databinding.ListShopListRecipeBinding
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.ui.base.BaseAdapter

class ShopListRecipeAdapter(private val dataset: List<RecipeBasic>) :
    BaseAdapter<ListShopListRecipeBinding, RecipeBasic>(dataset, R.layout.list_shop_list_recipe) {

    override fun bind(binding: ListShopListRecipeBinding, item: RecipeBasic) {
        binding.apply {
            recipe = item
        }
    }
}
