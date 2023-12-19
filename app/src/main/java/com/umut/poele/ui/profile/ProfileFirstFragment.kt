package com.umut.poele.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.umut.PoeleApplication
import com.umut.poele.R
import com.umut.poele.databinding.FragmentProfileFirstBinding
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.ui.login.AccountInfo
import kotlin.system.exitProcess

class ProfileFirstFragment : BaseFragment<FragmentProfileFirstBinding, ProfileFirstViewModel>(R.layout.fragment_profile_first) {

    override val vm: ProfileFirstViewModel by activityViewModels {
        ProfileFirstViewModelFactory((activity?.application as PoeleApplication).database.userDao())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewModel = vm

            vm.getUserWithUserId(AccountInfo.accountUserId).observe(this@ProfileFirstFragment.viewLifecycleOwner){
                user = it
            }
            buttonLogOut.setOnClickListener {
                MaterialAlertDialogBuilder(buttonLogOut.context).setTitle(R.string.logout_dialog_title).setMessage(R.string.logout_dialog_message)
                    .setNegativeButton(R.string.log_out_dialog_negative_button) { dialog, _ ->
                        dialog.dismiss()
                    }.setPositiveButton(R.string.log_out_dialog_positive_button) { _, _ ->
                        exitProcess(-1)
                    }.show()
            }
        }
    }
}
