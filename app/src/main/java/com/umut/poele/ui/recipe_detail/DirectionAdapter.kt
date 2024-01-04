package com.umut.poele.ui.recipe_detail

import com.umut.poele.R
import com.umut.poele.databinding.ListDirectionStepBinding
import com.umut.poele.ui.base.BaseAdapter
import com.umut.poele.ui.base.BaseViewHolder

class DirectionAdapter(dataset: List<String>): BaseAdapter<ListDirectionStepBinding,
        String>(dataset, R.layout.list_direction_step) {

    override fun bind(binding: ListDirectionStepBinding, item: String) {
        binding.apply {
            textStepDescription.text = item
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ListDirectionStepBinding>, position: Int) {
        super.onBindViewHolder(holder, position)

        holder.binder.apply {
            textStepHeader.text = String.format("Step %d", position+1)
        }
    }
}
