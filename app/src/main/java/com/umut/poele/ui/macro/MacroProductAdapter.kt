package com.umut.poele.ui.macro

import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.umut.poele.R
import com.umut.poele.databinding.ListMacroProductCardBinding
import com.umut.poele.domain.model.Supply
import com.umut.poele.ui.base.BaseAdapter
import com.umut.poele.ui.base.BaseViewHolder

class MacroProductAdapter(private val dataset: List<Supply>, private val vm: MacroFirstViewModel) : BaseAdapter<ListMacroProductCardBinding, Supply>(
    dataset, R
        .layout
        .list_macro_product_card
) {

    override fun bind(binding: ListMacroProductCardBinding, item: Supply) {
        binding.apply {
            supply = item
            viewModel = vm
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ListMacroProductCardBinding>, position: Int) {
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
