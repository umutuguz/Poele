package com.umut.poele.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
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
fun setIntText(textView: TextView, number: Number?) {
    if (number == null) {
        textView.text = ""
    } else {
        textView.text = number.toString()
    }
}

@BindingAdapter("setState")
fun setState(textView: TextView, state: States) {
    when (state) {
        States.UNUSED -> textView.text = "Unused"
        States.USED -> textView.text = "Used"
    }
}

@BindingAdapter("setListText")
fun setListText(textView: TextView, list: List<String>?) {
    if (list == null){
        textView.text = ""
    }else {
        textView.text = list.joinToString(", ")
    }
}

@BindingAdapter("setDifficultyLevel")
fun setDifficultyLevel(textView: TextView, level: Levels?) {
    when (level) {
        Levels.EASY -> textView.text = "Easy"
        Levels.INTERMEDIATE -> textView.text = "Intermediate"
        Levels.HARD -> textView.text = "Hard"

        else -> {textView.text = ""}
    }
}

@BindingAdapter("setDifficultyLevelString")
fun setDifficultyLevelString(textView: TextView, level: String?) {
    when (level) {
        "EASY" -> textView.text = "Easy"
        "INTERMEDIATE" -> textView.text = "Intermediate"
        "HARD" -> textView.text = "Hard"

        else -> {textView.text = ""}
    }
}

@BindingAdapter("setDate")
fun setDate(textView: TextView, date: LocalDate?) {
    if (date == null){
        textView.text = ""
    }else{
        textView.text = "${date.dayOfMonth}/${date.monthValue}/${date.year-2000}"
    }
}

@BindingAdapter("setCategory")
fun setCategory(textView: TextView, list: List<String>?) {
    if (list == null) {
        textView.text = ""
    }else {
        textView.text = "Category: ${list.joinToString(", ")}"
    }
}

@BindingAdapter( "amount","unit" )
fun setAmount(textView: TextView, amount: Double, unit: Units) {
    val unitString = when (unit) {
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

@BindingAdapter("setMenu")
fun setMenu(textView: TextView, mealTitle: Meals?){
    if (mealTitle == null) {
        textView.text = ""
    }else
    {
        when (mealTitle){
            Meals.BREAKFAST -> textView.text = "Breakfast"
            Meals.BRUNCH -> textView.text = "Brunch"
            Meals.LUNCH -> textView.text = "Lunch"
            Meals.DINNER -> textView.text = "Dinner"
        }
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
