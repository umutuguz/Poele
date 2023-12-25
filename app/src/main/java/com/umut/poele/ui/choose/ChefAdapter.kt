package com.umut.poele.ui.choose

import com.umut.poele.R
import com.umut.poele.databinding.ListChefBinding
import com.umut.poele.data.source.local.entity.UserEntity
import com.umut.poele.ui.base.BaseAdapter

class ChefAdapter(val dataset: List<UserEntity>) : BaseAdapter<ListChefBinding, UserEntity>(dataset, R.layout
    .list_chef) {

    override fun bind(binding: ListChefBinding, item: UserEntity) {
        binding.apply {
            user = item
        }
    }
}
