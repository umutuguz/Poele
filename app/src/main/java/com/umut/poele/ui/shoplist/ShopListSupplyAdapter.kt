package com.umut.poele.ui.shoplist

import com.umut.poele.R
import com.umut.poele.databinding.ListShopListSupplyBinding
import com.umut.poele.domain.model.Supply
import com.umut.poele.ui.base.BaseAdapter

class ShopListSupplyAdapter(private val dataset: List<Supply>) : BaseAdapter<ListShopListSupplyBinding, Supply>(
    dataset, R.layout.list_shop_list_supply
) {

    override fun bind(binding: ListShopListSupplyBinding, item: Supply) {
        binding.apply {
            supply = item
        }
    }
}
