package com.umut.poele.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.umut.poele.ui.base.BaseAdapter
import com.umut.poele.ui.base.BaseFragmentStateAdapter
import com.umut.poele.ui.base.ListAdapterItem

@BindingAdapter("setImage")
fun setImage(imageView: ImageView, imageId: Int) {
    imageView.setImageResource(imageId)
}

@BindingAdapter("setAdapter")
fun setAdapter(
    recyclerView: RecyclerView, adapter: BaseAdapter<ViewDataBinding, Any>?
) {
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
fun setIntText(textView: TextView, number: Number) {
    textView.text = number.toString()
}

@BindingAdapter("setState")
fun setState(textView: TextView, state: Boolean) {
    textView.text = if (state) {
        "Unused"
    }
    else {
        "Used"
    }
}
//
//@BindingAdapter("setViewPagerAdapter")
//fun setViewPagerAdapter(
//    viewPager2: ViewPager2, tabLayout: TabLayout, adapter: BaseFragmentStateAdapter<Fragment>?
//) {
//    adapter?.let {
//        viewPager2.adapter = it
//    }
//
//    TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
//        tab.text = Constants.RECIPE_DETAIL_TAB_NAME[position]
//    }.attach()
//}
