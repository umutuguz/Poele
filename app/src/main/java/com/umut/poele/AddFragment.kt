package com.umut.poele

import android.app.Dialog
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.umut.poele.base.BaseBottomSheetFragment
import com.umut.poele.databinding.FragmentAddBinding

class AddFragment : BaseBottomSheetFragment<FragmentAddBinding>(FragmentAddBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        BottomSheetBehavior.from(binding.modalBottomSheet).apply {
            state = BottomSheetBehavior.STATE_EXPANDED

        }

    }

    companion object {

        const val TAG = "ModalBottomSheet"
    }
}
