package com.umut.poele.ui.choose

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.umut.poele.R
import com.umut.poele.databinding.DialogFilterBinding
import com.umut.poele.ui.base.BaseBottomSheetFragment

class FilterDialog : BaseBottomSheetFragment<DialogFilterBinding, ChooseViewModel>(R.layout.dialog_filter) {

    override val vm: ChooseViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        BottomSheetBehavior.from(binding.modalBottomSheet).apply {
            state = BottomSheetBehavior.STATE_EXPANDED
            skipCollapsed = true
            isDraggable = false
            isFitToContents = true
            halfExpandedRatio = 0.0001f
        }

        binding.apply {
            viewModel = vm
        }
    }

    companion object {

        const val TAG = "FilterModalBottomSheet"
    }
}
