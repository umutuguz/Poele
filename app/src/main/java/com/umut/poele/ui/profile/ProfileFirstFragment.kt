package com.umut.poele.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.umut.poele.R
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.databinding.FragmentProfileFirstBinding
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.ui.home.HomeFirstViewModel

class ProfileFirstFragment: BaseFragment<FragmentProfileFirstBinding, BaseViewModel>
    (R.layout.fragment_profile_first, true) {

    override val vm: BaseViewModel
        get() = HomeFirstViewModel()
}
