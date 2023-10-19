package com.umut.poele.ui.profile

import com.umut.poele.R
import com.umut.poele.databinding.ListFavoriteBinding
import com.umut.poele.model.Recipe
import com.umut.poele.ui.base.BaseAdapter

class FavoriteListAdapter(private val dataset: List<Recipe>, private val vm: FavoriteViewModel) : BaseAdapter<ListFavoriteBinding, Recipe>(
    dataset, R.layout.list_favorite
) {

    override fun bind(binding: ListFavoriteBinding, item: Recipe) {
        binding.apply {
            viewModel = vm
            recipe = item
        }
    }
}
