package com.umut.poele.ui.supply

import com.umut.poele.R
import com.umut.poele.databinding.ListSupplyBinding
import com.umut.poele.databinding.ListSupplyCheckableBinding
import com.umut.poele.model.Supply
import com.umut.poele.ui.base.BaseAdapter

class CheckableSupplyListAdapter(val dataset: List<Supply>) : BaseAdapter<ListSupplyCheckableBinding, Supply>
    (dataset, R.layout.list_supply_checkable) {

    override fun bind(binding: ListSupplyCheckableBinding, item: Supply) {
        binding.apply {
            supply = item
        }
    }
}
