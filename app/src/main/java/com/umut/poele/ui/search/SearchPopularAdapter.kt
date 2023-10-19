package com.umut.poele.ui.search

import com.umut.poele.R
import com.umut.poele.databinding.ListPopularSearchBinding
import com.umut.poele.ui.base.BaseAdapter

class SearchPopularAdapter(private val dataset: List<String>) : BaseAdapter<ListPopularSearchBinding, String>(dataset, R.layout.list_popular_search) {

    override fun bind(binding: ListPopularSearchBinding, item: String) {
        binding.apply {
            chipPopularSearch.text = item
        }
    }
}
