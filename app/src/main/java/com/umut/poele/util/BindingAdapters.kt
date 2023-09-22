package com.umut.poele.util


import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.umut.poele.ui.base.BaseAdapter
import com.umut.poele.ui.base.ListAdapterItem

@BindingAdapter("setImage")
fun setImage(imageView: ImageView, imageId: Int) {
    imageView.setImageResource(imageId)
}

@BindingAdapter("setAdapter")
fun setAdapter(recyclerView: RecyclerView, adapter: BaseAdapter<ViewDataBinding,
        ListAdapterItem>?) {
    adapter?.let {
        recyclerView.adapter = it
    }
}

@Suppress("UNCHECKED_CAST")
@BindingAdapter("setList")
fun setList(recyclerView: RecyclerView, list: List<ListAdapterItem>?) {
    val adapter = recyclerView.adapter as BaseAdapter<ViewDataBinding, ListAdapterItem>
    adapter.data = list ?: listOf()
}

@BindingAdapter("setIntText")
fun setIntText(textView: TextView, integer: Int) {
    textView.text = integer.toString()
}
