package com.umut.poele.ui.recipe_detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.umut.poele.R
import com.umut.poele.domain.model.RecipeDataSource
import com.umut.poele.databinding.FragmentHomeRecipeDetailInfoBinding
import com.umut.poele.domain.model.Equipment
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeRecipeDetailInfoFragment(private val clickedRecipe: RecipeBasic) :
    BaseFragment<FragmentHomeRecipeDetailInfoBinding, HomeRecipeDetailViewModel>(
        R.layout.fragment_home_recipe_detail_info
    ) {

    override val vm: HomeRecipeDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            recipe = clickedRecipe
            vm.getEquipment(clickedRecipe.id)

            vm.recipeEquipmentLiveData.observe(viewLifecycleOwner) {
                adapter = EquipmentAdapter(it)
            }

            chipCalorie.setOnClickListener {
                Toast.makeText(requireContext(), "Calorie: ${clickedRecipe.macro.calorie}", Toast.LENGTH_SHORT).show()
            }
            chipProtein.setOnClickListener {
                Toast.makeText(requireContext(), "Protein: ${clickedRecipe.macro.protein}", Toast.LENGTH_SHORT).show()
            }
            chipFat.setOnClickListener {
                Toast.makeText(requireContext(), "Fat: ${clickedRecipe.macro.fat}", Toast.LENGTH_SHORT).show()
            }
            chipCarbohydrate.setOnClickListener {
                Toast.makeText(requireContext(), "Carbohydrate: ${clickedRecipe.macro.carb}", Toast.LENGTH_SHORT).show()
            }
            chipFiber.setOnClickListener {
                Toast.makeText(requireContext(), "Fiber: ${clickedRecipe.macro.fiber}", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
