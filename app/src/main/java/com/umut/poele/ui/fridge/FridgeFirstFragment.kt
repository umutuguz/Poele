package com.umut.poele.ui.fridge

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.umut.PoeleApplication
import com.umut.poele.R
import com.umut.poele.domain.model.SupplyDataSource
import com.umut.poele.databinding.FragmentFridgeFirstBinding
import com.umut.poele.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class FridgeFirstFragment : BaseFragment<FragmentFridgeFirstBinding, FridgeFirstViewModel>
    (R.layout.fragment_fridge_first) {

    override val vm: FridgeFirstViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            vm.supplyListLiveData.observe(viewLifecycleOwner) {
                Log.i("umutcan", "fragment observe")
                adapter = SupplyListAdapter(it, vm)
            }
            viewModel = vm
        }
    }
}
