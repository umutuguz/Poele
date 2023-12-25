package com.umut.poele.ui.profile

import com.umut.poele.R
import com.umut.poele.databinding.ListFavoriteBinding
import com.umut.poele.domain.model.RecipeModel
import com.umut.poele.ui.base.BaseAdapter

class FavoriteListAdapter(private val dataset: List<RecipeModel>, private val vm: FavoriteViewModel) : BaseAdapter<ListFavoriteBinding, RecipeModel>(
    dataset, R.layout.list_favorite
) {

    override fun bind(binding: ListFavoriteBinding, item: RecipeModel) {
        binding.apply {
            viewModel = vm
            recipeModel = item
        }
    }
}
