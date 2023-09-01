package com.umut.poele

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umut.poele.base.BaseFragment
import com.umut.poele.databinding.FragmentMacroFirstBinding

class MacroFirstFragment : BaseFragment() {

    private var _binding: FragmentMacroFirstBinding? = null

    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMacroFirstBinding.inflate(inflater, container, false)
        return binding.root
    }
}
