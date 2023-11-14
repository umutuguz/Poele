package com.umut.poele.ui.choose

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.umut.poele.R
import com.umut.poele.data.UserDataSource
import com.umut.poele.databinding.DialogChooseHomeBinding
import com.umut.poele.ui.base.BaseBottomSheetFragment

class ChooseHomeDialog :
    BaseBottomSheetFragment<DialogChooseHomeBinding, ChooseViewModel>(R.layout.dialog_choose_home) {

    override val vm: ChooseViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        BottomSheetBehavior.from(binding.modalBottomSheet).apply {
            state = BottomSheetBehavior.STATE_EXPANDED
            isDraggable = false
        }

        binding.apply {
            adapter = HomeAdapter(UserDataSource().loadUser())
            viewModel = vm
        }
    }

    companion object {

        const val TAG = "HomeModalBottomSheet"
    }
}
