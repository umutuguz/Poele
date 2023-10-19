package com.umut.poele.ui.macro

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.umut.poele.R
import com.umut.poele.databinding.DialogChallengeBinding
import com.umut.poele.ui.base.BaseBottomSheetFragment

class ChallengeDialog : BaseBottomSheetFragment<DialogChallengeBinding, ChallengeViewModel>(R.layout.dialog_challenge) {

    override val vm: ChallengeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        BottomSheetBehavior.from(binding.modalBottomSheet).apply {
            state = BottomSheetBehavior.STATE_EXPANDED
            skipCollapsed = true
        }

        binding.apply {
            viewModel = vm
        }
    }
}
