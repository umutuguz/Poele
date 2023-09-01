package com.umut.poele

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umut.poele.base.BaseFragment
import com.umut.poele.databinding.FragmentProfileFirstBinding

class ProfileFirstFragment: BaseFragment() {

    private var _binding: FragmentProfileFirstBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileFirstBinding.inflate(inflater, container, false)
        return binding.root
    }
}
