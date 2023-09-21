package com.umut.poele.ui.add

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.umut.poele.databinding.FragmentAddBinding
import com.umut.poele.ui.base.BaseBottomSheetFragment

class AddFragment : BaseBottomSheetFragment<FragmentAddBinding>(FragmentAddBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        BottomSheetBehavior.from(binding.modalBottomSheet).apply {
            state = BottomSheetBehavior.STATE_EXPANDED
            saveFlags = BottomSheetBehavior.SAVE_ALL

        }

    }

    companion object {

        const val TAG = "ModalBottomSheet"
    }
}
