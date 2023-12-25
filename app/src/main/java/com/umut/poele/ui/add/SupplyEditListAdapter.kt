package com.umut.poele.ui.add

import com.umut.poele.R
import com.umut.poele.databinding.ListEditSupplyBinding
import com.umut.poele.domain.model.Supply
import com.umut.poele.ui.base.BaseAdapter

class SupplyEditListAdapter(private val dataset: List<Supply>, private val vm: AddEditSupplyViewModel, private val forPickSupply: Boolean) :
    BaseAdapter<ListEditSupplyBinding,
            Supply>(
    dataset, R
        .layout.list_edit_supply
) {

    override fun bind(binding: ListEditSupplyBinding, item: Supply) {
        binding.apply {
            supply = item
            viewModel = vm

            if (forPickSupply) {
                cardSupply.setOnClickListener {
                    vm.onMacroMealEntrySupplyClicked()
                }
            } else {
                vm.onSupplyClicked(item)
            }
        }
    }
}
