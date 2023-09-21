package com.umut.poele.ui.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.umut.poele.R

abstract class BaseBottomSheetFragment<T : ViewBinding>(
    private val inflate: (
        LayoutInflater, ViewGroup?, Boolean
    ) -> T
) : BottomSheetDialogFragment() {

    private var _binding: T? = null

    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

}
