package com.umut.poele.ui.choose

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.umut.PoeleApplication
import com.umut.poele.R
import com.umut.poele.databinding.DialogChooseChefBinding
import com.umut.poele.ui.base.BaseBottomSheetFragment

class ChooseChefDialog : BaseBottomSheetFragment<DialogChooseChefBinding, ChooseViewModel>(R.layout.dialog_choose_chef) {

    override val vm: ChooseViewModel by activityViewModels {
        ChooseViewModelFactory((activity?.application as PoeleApplication).database.userDao())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        BottomSheetBehavior.from(binding.modalBottomSheet).apply {
            state = BottomSheetBehavior.STATE_EXPANDED
            isDraggable = false
        }

        binding.apply {
            vm.getAllUsers().observe(this@ChooseChefDialog.viewLifecycleOwner) { userList ->
                adapter = ChefAdapter(userList)
            }

            viewModel = vm
        }
    }

    companion object {

        const val TAG = "ChefModalBottomSheet"
    }
}

object SelectedUser {

    var userId: Int = 1
}
