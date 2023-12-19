package com.umut.poele.ui.choose

import com.umut.poele.R
import com.umut.poele.database.address.Address
import com.umut.poele.database.user.User
import com.umut.poele.databinding.ListHomeBinding
import com.umut.poele.ui.base.BaseAdapter
import com.umut.poele.ui.base.BaseViewHolder

class HomeAdapter(val dataset: List<Address>, private val currentUser: User) : BaseAdapter<ListHomeBinding, Address>(
    dataset, R.layout.list_home
) {

    override fun bind(binding: ListHomeBinding, item: Address) {
        binding.apply {
            user = currentUser
            address = item
        }
    }

}
