package com.umut.poele.ui.fridge

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.umut.poele.R
import com.umut.poele.databinding.DialogSupplyMoreOptionBinding
import com.umut.poele.ui.base.BaseBottomSheetFragment

class SupplyMoreOptionDialog : BaseBottomSheetFragment<DialogSupplyMoreOptionBinding, SupplyMoreOptionViewModel>(R.layout.dialog_supply_more_option) {

    override val vm: SupplyMoreOptionViewModel by viewModels()
    private val args: SupplyMoreOptionDialogArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        BottomSheetBehavior.from(binding.modalBottomSheet).apply {
            state = BottomSheetBehavior.STATE_EXPANDED
            skipCollapsed = true
        }

        binding.apply {
            viewModel = vm
            clickedSupply = args.clickedSupply
        }
    }
}
