package com.umut.poele.ui.home

import com.umut.poele.R
import com.umut.poele.databinding.ItemMenuCardBinding
import com.umut.poele.domain.model.MenuCard
import com.umut.poele.ui.base.BaseAdapter

class MenuCardAdapter(private val dataset: List<MenuCard>) : BaseAdapter<ItemMenuCardBinding,
        MenuCard>(dataset, R.layout.item_menu_card) {

    override fun bind(binding: ItemMenuCardBinding, item: MenuCard) {
        binding.apply {
            menuCardModel = item
        }
    }
}
