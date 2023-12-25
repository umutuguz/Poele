package com.umut.poele.ui.macro

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.datepicker.MaterialDatePicker
import com.umut.poele.R
import com.umut.poele.domain.model.SupplyDataSource
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.databinding.FragmentMacroFirstBinding

class MacroFirstFragment : BaseFragment<FragmentMacroFirstBinding, MacroFirstViewModel>
    (R.layout.fragment_macro_first) {

    override val vm: MacroFirstViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText(R.string.date_picker_title)
            .build()

        binding.apply {
            adapter = MacroProductAdapter(SupplyDataSource().loadSupply(), vm)
            viewModel = vm
            layoutDatePicker.setOnClickListener {
                datePicker.show(requireActivity().supportFragmentManager, "DatePicker")
            }
        }
    }
}
