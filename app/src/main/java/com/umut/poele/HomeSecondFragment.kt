package com.umut.poele

import android.os.Bundle
import android.support.v4.os.IResultReceiver._Parcel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umut.poele.base.BaseFragment
import com.umut.poele.databinding.FragmentHomeSecondBinding

class HomeSecondFragment: BaseFragment() {

    private var _binding: FragmentHomeSecondBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeSecondBinding.inflate(inflater, container, false)
        return binding.root
    }
}
