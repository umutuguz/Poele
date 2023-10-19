package com.umut.poele.ui.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.umut.poele.R
import com.umut.poele.databinding.FragmentAddShopListBinding
import com.umut.poele.ui.base.BaseFragment

class AddShopListFragment : BaseFragment<FragmentAddShopListBinding, AddShopListViewModel>(R.layout.fragment_add_shop_list) {

    override val vm: AddShopListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewModel = vm
        }
    }
}
