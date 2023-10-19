package com.umut.poele.ui.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.umut.poele.R
import com.umut.poele.databinding.FragmentAddEditSupplyBinding
import com.umut.poele.ui.base.BaseFragment

class AddEditSupplyFragment : BaseFragment<FragmentAddEditSupplyBinding, AddEditSupplyViewModel>(R.layout.fragment_add_edit_supply) {

    override val vm: AddEditSupplyViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewModel = vm
        }
    }
}
