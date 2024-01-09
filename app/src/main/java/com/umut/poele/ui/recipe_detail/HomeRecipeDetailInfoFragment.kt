package com.umut.poele.ui.recipe_detail

import android.os.Bundle
import android.provider.CalendarContract.Instances
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.umut.poele.BR
import com.umut.poele.R
import com.umut.poele.databinding.FragmentHomeRecipeDetailInfoBinding
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.ui.base.BaseDetailFragment
import com.umut.poele.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeRecipeDetailInfoFragment : BaseDetailFragment() {

    private lateinit var binding: FragmentHomeRecipeDetailInfoBinding
    val vm: HomeRecipeDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home_recipe_detail_info, container, false
        )

        return binding.root
    }

    override fun updateRecipe(updatedRecipe: RecipeBasic) {
        vm.getEquipment(updatedRecipe.id)
        binding.recipe = updatedRecipe
        setClickListeners(updatedRecipe)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            vm.recipeEquipmentLiveData.observe(viewLifecycleOwner) {
                adapter = EquipmentAdapter(it)
            }
        }
    }

    private fun setClickListeners(recipe: RecipeBasic) {
        binding.apply {
            chipCalorie.setOnClickListener {
                Toast.makeText(requireContext(), "Calorie: ${recipe.macro.calorie}", Toast.LENGTH_SHORT).show()
            }
            chipProtein.setOnClickListener {
                Toast.makeText(requireContext(), "Protein: ${recipe.macro.protein}", Toast.LENGTH_SHORT).show()
            }
            chipFat.setOnClickListener {
                Toast.makeText(requireContext(), "Fat: ${recipe.macro.fat}", Toast.LENGTH_SHORT).show()
            }
            chipCarbohydrate.setOnClickListener {
                Toast.makeText(requireContext(), "Carbohydrate: ${recipe.macro.carb}", Toast.LENGTH_SHORT).show()
            }
            chipFiber.setOnClickListener {
                Toast.makeText(requireContext(), "Fiber: ${recipe.macro.fiber}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
