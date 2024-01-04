package com.umut.poele.ui.recipe_detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.umut.poele.R
import com.umut.poele.databinding.FragmentHomeRecipeDetailDirectionBinding
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeRecipeDetailDirectionFragment(private val clickedRecipe: RecipeBasic) :
    BaseFragment<FragmentHomeRecipeDetailDirectionBinding, HomeRecipeDetailViewModel>(
        R.layout.fragment_home_recipe_detail_direction
    ) {

    override val vm: HomeRecipeDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            adapter = DirectionAdapter(clickedRecipe.directions)
        }

    }
}
