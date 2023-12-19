package com.umut.poele.ui.home

import com.umut.poele.R
import com.umut.poele.databinding.ItemMenuCardBinding
import com.umut.poele.model.MenuCardModel
import com.umut.poele.ui.base.BaseAdapter

class MenuCardAdapter(private val dataset: List<MenuCardModel>) : BaseAdapter<ItemMenuCardBinding,
        MenuCardModel>(dataset, R.layout.item_menu_card) {

    override fun bind(binding: ItemMenuCardBinding, item: MenuCardModel) {
        binding.apply {
            menuCardModel = item
        }
    }
}
