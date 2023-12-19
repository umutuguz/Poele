package com.umut.poele.ui.recipe_detail

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.umut.poele.R
import com.umut.poele.data.RecipeDataSource
import com.umut.poele.databinding.FragmentHomeRecipeDetailInfoBinding
import com.umut.poele.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeRecipeDetailInfoFragment :
    BaseFragment<FragmentHomeRecipeDetailInfoBinding, HomeRecipeDetailViewModel>(
        R.layout.fragment_home_recipe_detail_info
    ) {

    override val vm: HomeRecipeDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            adapter = EquipmentAdapter(RecipeDataSource().loadRecipe()[0].equipments)
            recipeModel = RecipeDataSource().loadRecipe()[0]
        }
    }

}
