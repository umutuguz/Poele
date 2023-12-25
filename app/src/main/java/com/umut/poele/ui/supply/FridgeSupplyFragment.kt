package com.umut.poele.ui.supply

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.umut.poele.R
import com.umut.poele.domain.model.SupplyDataSource
import com.umut.poele.databinding.FragmentFridgeSupplyBinding
import com.umut.poele.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FridgeSupplyFragment: BaseFragment<FragmentFridgeSupplyBinding, FridgeSupplyViewModel>(R.layout
    .fragment_fridge_supply) {

    override val vm: FridgeSupplyViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            adapter = CheckableSupplyListAdapter(SupplyDataSource().loadSupply())
            viewModel = vm
        }
    }
}
