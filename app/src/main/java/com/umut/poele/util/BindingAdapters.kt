package com.umut.poele.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.umut.poele.ui.base.BaseAdapter
import com.umut.poele.ui.base.ListAdapterItem
import java.time.LocalDate

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
fun setState(textView: TextView, state: States) {
    when (state) {
        States.UNUSED -> textView.text = "Unused"
        States.USED -> textView.text = "Used"
    }
}

@BindingAdapter("setListText")
fun setListText(textView: TextView, list: List<String>) {
    textView.text = list.joinToString(", ")
}

@BindingAdapter("setDifficultyLevel")
fun setDifficultyLevel(chip: Chip, level: Levels) {
    when (level) {
        Levels.EASY -> chip.text = "Easy"
        Levels.INTERMEDIATE -> chip.text = "Intermediate"
        Levels.HARD -> chip.text = "Hard"
    }
}

@BindingAdapter("setDate")
fun setDate(textView: TextView, date: LocalDate) {
    textView.text = date.toString()
}

@BindingAdapter("setCategory")
fun setCategory(textView: TextView, list: List<String>) {
    textView.text = "Category: ${list.joinToString(", ")}"
}

@BindingAdapter( "amount","unit" )
fun setAmount(textView: TextView, amount: Double, unit: Units) {
    var unitString = when (unit) {
        Units.GRAM -> "g"
        Units.ML -> "ml"
        Units.TABLESPOON -> "tbps."
        Units.TEASPOON -> "tsp."
        Units.DESSERTSPOON -> "dsp."
        Units.CUP -> "cup"
        Units.PINCH -> "pinch"
        Units.PIECE -> "piece"
    }
    textView.text = "$amount $unitString"
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
