package com.umut.poele.ui.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.umut.poele.R
import com.umut.poele.domain.model.SupplyDataSource
import com.umut.poele.databinding.FragmentEditSupplyBinding
import com.umut.poele.ui.base.BaseFragment

class EditSupplyFragment : BaseFragment<FragmentEditSupplyBinding, AddEditSupplyViewModel>(R.layout.fragment_edit_supply) {

    override val vm: AddEditSupplyViewModel by viewModels()
    private val args: EditSupplyFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewModel = vm
            adapter = SupplyEditListAdapter(SupplyDataSource().loadSupply(), vm, args.forPickSupply)

        }
    }
}
