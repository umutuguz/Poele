package com.umut.poele.adapter

import android.content.Context
import android.service.autofill.Dataset
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.umut.poele.R
import com.umut.poele.model.MenuCard

class ViewPagerMenuCardAdapter(
    private val context: Context,
    private val dataset: List<MenuCard>
) : RecyclerView.Adapter<ViewPagerMenuCardAdapter.ViewPagerMenuCardViewHolder>() {

    class ViewPagerMenuCardViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.image_menu_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerMenuCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu_card, parent,
            false)
        return ViewPagerMenuCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerMenuCardViewHolder, position: Int) {
        val item = dataset[position]
        holder.imageView.setImageResource(item.imageSourceId)
    }

    override fun getItemCount(): Int = dataset.size

}
