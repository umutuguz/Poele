package com.umut.poele

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umut.poele.base.BaseFragment
import com.umut.poele.databinding.FragmentHomeFirstBinding

class HomeFirstFragment : BaseFragment() {

    private var _binding: FragmentHomeFirstBinding? = null

    private val binding //value
        get() = _binding!! // variable
    // TODO: Encapsulation
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeFirstBinding.inflate(inflater, container, false)
        return binding.root
    }
}
