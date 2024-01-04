package com.umut.poele.ui.profile

import com.umut.poele.R
import com.umut.poele.databinding.ListFavoriteBinding
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.ui.base.BaseAdapter

class FavoriteListAdapter(private val dataset: List<RecipeBasic>, private val vm: FavoriteViewModel) : BaseAdapter<ListFavoriteBinding, RecipeBasic>(
    dataset, R.layout.list_favorite
) {

    override fun bind(binding: ListFavoriteBinding, item: RecipeBasic) {
        binding.apply {
            viewModel = vm
            recipe = item
        }
    }
}
