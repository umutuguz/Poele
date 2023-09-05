package com.umut.poele.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.umut.poele.MainActivity

abstract class BaseFragment<T : ViewBinding>(
    private val inflate: (
        LayoutInflater, ViewGroup?,
        Boolean
    ) -> T,
    private val isNavigationBarVisible: Boolean
) :
    Fragment
        () {

    private var _binding: T? = null
    val binding get() = _binding!!

    var isToolbarVisible: Boolean = isNavigationBarVisible

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as MainActivity
        if (!isNavigationBarVisible) {
            activity.binding.navigationBar.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
