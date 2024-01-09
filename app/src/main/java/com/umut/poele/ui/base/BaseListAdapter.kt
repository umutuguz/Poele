package com.umut.poele.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseListAdapter<B : ViewDataBinding, T : Any>(
    @LayoutRes val layoutId: Int
) : RecyclerView.Adapter<BaseViewHolder<B>>() {

    val data: MutableList<T> = mutableListOf()

    abstract fun bind(binding: B, item: T)

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: BaseViewHolder<B>, position: Int) {
        bind(holder.binder, data[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<B> {
        val binder = DataBindingUtil.inflate<B>(
            LayoutInflater.from(parent.context), layoutId, parent, false
        )
        return BaseViewHolder(binder)
    }

    fun submitList(list: List<T>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

}
