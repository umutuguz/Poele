package com.umut.poele.ui.search

import com.umut.poele.R
import com.umut.poele.databinding.ListSearchSupplyBinding
import com.umut.poele.databinding.ListSupplyBinding
import com.umut.poele.model.Supply
import com.umut.poele.ui.base.BaseAdapter

class SearchIngredientAdapter(private val dataset: List<Supply>, private val vm: SearchViewModel) : BaseAdapter<ListSearchSupplyBinding, Supply>(dataset, R.layout
    .list_search_supply) {

    override fun bind(binding: ListSearchSupplyBinding, item: Supply) {
        binding.apply {
            supply = item
            cardSupply.setOnClickListener {
                vm.onSupplyClicked(item)
            }
        }
    }
}
