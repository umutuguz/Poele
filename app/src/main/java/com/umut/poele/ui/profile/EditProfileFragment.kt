package com.umut.poele.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.umut.poele.R
import com.umut.poele.databinding.FragmentEditProfileBinding
import com.umut.poele.ui.base.BaseFragment

class EditProfileFragment : BaseFragment<FragmentEditProfileBinding, EditProfileViewModel>(R.layout.fragment_edit_profile) {

    override val vm: EditProfileViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

        }
    }
}
