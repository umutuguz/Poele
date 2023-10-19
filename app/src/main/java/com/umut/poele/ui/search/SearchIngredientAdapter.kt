package com.umut.poele.ui.search

import com.umut.poele.R
import com.umut.poele.databinding.ListSupplyBinding
import com.umut.poele.model.Supply
import com.umut.poele.ui.base.BaseAdapter

class SearchIngredientAdapter(private val dataset: List<Supply>) : BaseAdapter<ListSupplyBinding, Supply>(dataset, R.layout.list_supply) {

    override fun bind(binding: ListSupplyBinding, item: Supply) {
        binding.apply {
            supply = item
        }
    }
}
