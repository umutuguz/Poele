package com.umut.poele.ui.recipe

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.umut.poele.R
import com.umut.poele.data.RecipeDataSource
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.databinding.FragmentHomeRecipeBinding
import com.umut.poele.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class HomeRecipeFragment: BaseFragment<FragmentHomeRecipeBinding, BaseViewModel>
    (R.layout.fragment_home_recipe, true) {

    override val vm: HomeRecipeViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            adapterRecipe = RecipeListAdapter(RecipeDataSource().loadRecipe())
            viewModel = vm
        }

    }

}
