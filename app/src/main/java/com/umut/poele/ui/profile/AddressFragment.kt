package com.umut.poele.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.umut.poele.R
import com.umut.poele.databinding.FragmentAddressBinding
import com.umut.poele.ui.base.BaseFragment

class AddressFragment : BaseFragment<FragmentAddressBinding, AddressViewModel>(R.layout.fragment_address) {

    override val vm: AddressViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

        }
    }
}
