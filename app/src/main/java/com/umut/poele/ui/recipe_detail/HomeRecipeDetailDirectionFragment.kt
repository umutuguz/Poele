package com.umut.poele.ui.recipe_detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.umut.poele.R
import com.umut.poele.data.RecipeDataSource
import com.umut.poele.databinding.FragmentHomeRecipeDetailDirectionBinding
import com.umut.poele.model.Recipe
import com.umut.poele.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeRecipeDetailDirectionFragment :
    BaseFragment<FragmentHomeRecipeDetailDirectionBinding, HomeRecipeDetailViewModel>(
        R.layout.fragment_home_recipe_detail_direction,
        false
    ) {

    override val vm: HomeRecipeDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            adapter = DirectionAdapter(RecipeDataSource().loadRecipe()[0].directions)

        }

    }
}
