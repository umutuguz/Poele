package com.umut.poele.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.umut.PoeleApplication
import com.umut.poele.R
import com.umut.poele.databinding.FragmentHomeFirstBinding
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.ui.login.AccountInfo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.jetbrains.annotations.ApiStatus.Experimental

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class HomeFirstFragment : BaseFragment<FragmentHomeFirstBinding, HomeFirstViewModel>(R.layout.fragment_home_first) {

    override val vm: HomeFirstViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
//            vm.getAllRecipeCategories().observe(this@HomeFirstFragment.viewLifecycleOwner) { list ->
//                adapterRecipeCategory = RecipeCategoryAdapter(list, vm, vm)
//            }

            adapterRecipeCategory = RecipeCategoryAdapter(vm.getMealTypes(), vm, vm)

            recyclerRecipeCategories.adapter?.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY

//            vm.getMenuCardWithUserId(AccountInfo.accountUserId).observe(this@HomeFirstFragment.viewLifecycleOwner) { list ->
//                viewpagerMenuCard.adapter = MenuCardAdapter(loadMenuCardModel(list))
//            }

            vm.menuCardListLiveData.observe(viewLifecycleOwner){
                viewpagerMenuCard.adapter = MenuCardAdapter(it)
            }
        }
    }

}
