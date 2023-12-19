package com.umut.poele.ui.fridge

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.umut.poele.R
import com.umut.poele.data.SupplyDataSource
import com.umut.poele.databinding.FragmentFridgeFirstBinding
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.ui.choose.SelectedUser
import com.umut.poele.ui.home.HomeFirstViewModel

class FridgeFirstFragment : BaseFragment<FragmentFridgeFirstBinding, FridgeFirstViewModel>
    (R.layout.fragment_fridge_first) {

    override val vm: FridgeFirstViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

//            vm.getAllSuppliesWithUserId(SelectedUser.userId).observe(this@FridgeFirstFragment.viewLifecycleOwner){
//                adapter = SupplyListAdapter(it, vm)
//            }
            viewModel = vm
        }
    }
}
