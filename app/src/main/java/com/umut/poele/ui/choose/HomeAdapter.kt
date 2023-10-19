package com.umut.poele.ui.choose

import com.umut.poele.R
import com.umut.poele.databinding.ListHomeBinding
import com.umut.poele.model.User
import com.umut.poele.ui.base.BaseAdapter

class HomeAdapter(val dataset: List<User>) : BaseAdapter<ListHomeBinding, User>(dataset, R.layout
    .list_home) {

    override fun bind(binding: ListHomeBinding, item: User) {
        binding.apply {
            user = item
        }
    }
}
