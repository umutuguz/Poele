package com.umut.poele.ui.recipe_detail

import com.umut.poele.R
import com.umut.poele.databinding.ListEquipmentsBinding
import com.umut.poele.domain.model.Equipment
import com.umut.poele.ui.base.BaseAdapter

class EquipmentAdapter(dataset: List<Equipment>) :
    BaseAdapter<ListEquipmentsBinding, Equipment>(dataset, R.layout.list_equipments) {

    override fun bind(binding: ListEquipmentsBinding, item: Equipment) {
        binding.apply {
            equipment = item
        }
    }
}
