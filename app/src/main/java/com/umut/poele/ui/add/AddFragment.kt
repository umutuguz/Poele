package com.umut.poele.ui.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.umut.poele.R
import com.umut.poele.databinding.FragmentAddBinding
import com.umut.poele.ui.base.BaseBottomSheetFragment

class AddFragment : BaseBottomSheetFragment<FragmentAddBinding, AddViewModel>(R.layout.fragment_add) {

    override val vm: AddViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        BottomSheetBehavior.from(binding.modalBottomSheet).apply {
            state = BottomSheetBehavior.STATE_EXPANDED
            isDraggable = false
        }

        binding.apply {
            viewModel = vm
        }
    }

    companion object {

        const val TAG = "AddModalBottomSheet"
    }
}
