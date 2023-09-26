package com.umut.poele.ui.recipe_detail

import com.umut.poele.R
import com.umut.poele.databinding.ListEquipmentsBinding
import com.umut.poele.ui.base.BaseAdapter

class EquipmentAdapter(private val dataset: List<String>) :
    BaseAdapter<ListEquipmentsBinding, String>(dataset, R.layout.list_equipments) {

    override fun bind(binding: ListEquipmentsBinding, item: String) {
        binding.apply {
            chipEquipment.text = item
        }
    }
}
