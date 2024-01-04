package com.umut.poele.ui.search

import com.umut.poele.R
import com.umut.poele.databinding.ListRecentSearchBinding
import com.umut.poele.ui.base.BaseAdapter

class SearchRecentAdapter(private val dataset: List<String>) : BaseAdapter<com.umut.poele.databinding.ListRecentSearchBinding, String>(dataset, R.layout.list_recent_search){

    override fun bind(binding: ListRecentSearchBinding, item: String) {
        binding.apply {
            textRecentSearch.text = item
        }
    }
}
