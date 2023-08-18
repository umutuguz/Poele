package com.umut.poele

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umut.poele.databinding.FragmentFridgeFirstBinding

class FridgeFirstFragment : Fragment() {
    private var _binding: FragmentFridgeFirstBinding? = null

    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFridgeFirstBinding.inflate(inflater, container, false)
        return binding.root
    }
}
