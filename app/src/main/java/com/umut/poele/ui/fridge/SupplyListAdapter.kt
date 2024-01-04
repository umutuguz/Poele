package com.umut.poele.ui.fridge

import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.umut.poele.R
import com.umut.poele.databinding.ListSupplyBinding
import com.umut.poele.domain.model.Supply
import com.umut.poele.ui.base.BaseAdapter
import com.umut.poele.ui.base.BaseViewHolder

class SupplyListAdapter(val dataset: List<Supply>, val vm: FridgeFirstViewModel)
    : BaseAdapter<ListSupplyBinding, Supply>(dataset, R.layout.list_supply) {

    override fun bind(binding: ListSupplyBinding, item: Supply) {
        binding.apply {
            supply = item
            viewModel = vm
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ListSupplyBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.binder.imageDelete.setOnClickListener {
            MaterialAlertDialogBuilder(holder.binder.imageDelete.context).setTitle(R.string.delete_dialog_title)
                .setMessage(R.string.delete_dialog_message).setNeutralButton(R.string.delete_dialog_neutral_button) { dialog, _ ->
                    dialog.cancel()
                }.setNegativeButton(R.string.delete_dialog_negative_button) { dialog, _ ->
                    dialog.dismiss()
                }.setPositiveButton(R.string.delete_dialog_positive_button) { dialog, _ ->
                    dialog.cancel()
                }.show()
        }

    }

}
