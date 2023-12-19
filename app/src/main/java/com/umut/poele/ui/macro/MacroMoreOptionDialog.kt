package com.umut.poele.ui.macro

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.umut.poele.R
import com.umut.poele.databinding.DialogMacroMoreOptionBinding
import com.umut.poele.ui.base.BaseBottomSheetFragment

class MacroMoreOptionDialog : BaseBottomSheetFragment<DialogMacroMoreOptionBinding, MacroMoreOptionViewModel>(R.layout.dialog_macro_more_option) {

    override val vm: MacroMoreOptionViewModel by viewModels()
    private val args: MacroMoreOptionDialogArgs by navArgs()

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
