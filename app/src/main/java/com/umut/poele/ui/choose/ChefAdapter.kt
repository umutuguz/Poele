package com.umut.poele.ui.choose

import com.umut.poele.R
import com.umut.poele.databinding.ListChefBinding
import com.umut.poele.model.User
import com.umut.poele.ui.base.BaseAdapter

class ChefAdapter(val dataset: List<User>) : BaseAdapter<ListChefBinding, User>(dataset, R.layout
    .list_chef) {

    override fun bind(binding: ListChefBinding, item: User) {
        binding.apply {
            user = item
        }
    }
}
