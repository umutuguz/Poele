package com.umut.poele.ui.add

import com.umut.poele.R
import com.umut.poele.databinding.ItemEnterDailyMenuBinding
import com.umut.poele.model.MenuCard
import com.umut.poele.ui.base.BaseAdapter

class EnterDailyMenuTabAdapter(private val dataset: List<MenuCard>) : BaseAdapter<ItemEnterDailyMenuBinding, MenuCard>(dataset, R.layout.item_enter_daily_menu) {

    override fun bind(binding: ItemEnterDailyMenuBinding, item: MenuCard) {
        binding.apply {

        }
    }
}
