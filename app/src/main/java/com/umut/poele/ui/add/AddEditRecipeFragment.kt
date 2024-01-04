package com.umut.poele.ui.add

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.umut.poele.R
import com.umut.poele.databinding.FragmentAddEditRecipeBinding
import com.umut.poele.ui.base.BaseFragment

class AddEditRecipeFragment : BaseFragment<FragmentAddEditRecipeBinding, AddEditRecipeViewModel>(R.layout.fragment_add_edit_recipe) {

    override val vm: AddEditRecipeViewModel by viewModels()
    private val args: AddEditRecipeFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewModel = vm
            if (args.fromEditRecipe) {
                clickedRecipe = args.clickedRecipe
                textPageTitle.text = getString(R.string.edit_recipe)

            } else {
                textPageTitle.text = getString(R.string.add_recipe)
            }
        }
    }
}
