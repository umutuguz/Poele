package com.umut.poele.ui.recipe

import android.util.Log
import com.umut.poele.R
import com.umut.poele.databinding.ListRecipeBinding
import com.umut.poele.data.source.local.entity.RecipeEntity
import com.umut.poele.ui.base.BaseAdapter

class RecipeListAdapter(private val dataset: List<RecipeEntity>, private val vm: HomeRecipeViewModel) :
    BaseAdapter<ListRecipeBinding, RecipeEntity>(dataset, R.layout.list_recipe) {

    override fun bind(binding: ListRecipeBinding, item: RecipeEntity) {
        binding.apply {
            Log.i("umutcan", "dataset:${dataset.size}")
            Log.i("umutcan", "itemTitle:${item.title}")
            recipe = item
            cardRecipe.setOnClickListener {
                vm.onRecipeClicked(item)
            }
        }
    }
}
