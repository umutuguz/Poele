package com.umut.poele.ui.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.umut.poele.R
import com.umut.poele.databinding.FragmentAddEditSupplyBinding
import com.umut.poele.ui.base.BaseFragment

class AddEditSupplyFragment
    : BaseFragment<FragmentAddEditSupplyBinding, AddEditSupplyViewModel>(R.layout.fragment_add_edit_supply) {

    override val vm: AddEditSupplyViewModel by viewModels()
    private val args: AddEditSupplyFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewModel = vm
            if (args.fromEditSupply) {
                clickedSupply = args.clickedSupply
                textPageTitle.text = getString(R.string.edit_supply)

            } else {
                textPageTitle.text = getString(R.string.add_supply)

            }
        }
    }
}
