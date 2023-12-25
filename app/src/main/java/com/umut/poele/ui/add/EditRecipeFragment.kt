package com.umut.poele.ui.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.umut.poele.R
import com.umut.poele.domain.model.RecipeDataSource
import com.umut.poele.databinding.FragmentEditRecipeBinding
import com.umut.poele.ui.base.BaseFragment

class EditRecipeFragment : BaseFragment<FragmentEditRecipeBinding, AddEditRecipeViewModel>(R.layout.fragment_edit_recipe) {

    override val vm: AddEditRecipeViewModel by viewModels()
    private val args: EditRecipeFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewModel = vm
            adapter = RecipeEditListAdapter(RecipeDataSource().loadRecipe(), vm, args.forPickRecipe)
        }
    }
}
