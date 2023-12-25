package com.umut.poele.ui.choose

import com.umut.poele.R
import com.umut.poele.data.source.local.entity.AddressEntity
import com.umut.poele.data.source.local.entity.UserEntity
import com.umut.poele.databinding.ListHomeBinding
import com.umut.poele.ui.base.BaseAdapter

class HomeAdapter(val dataset: List<AddressEntity>, private val currentUser: UserEntity) : BaseAdapter<ListHomeBinding, AddressEntity>(
    dataset, R.layout.list_home
) {

    override fun bind(binding: ListHomeBinding, item: AddressEntity) {
        binding.apply {
            user = currentUser
            address = item
        }
    }

}
