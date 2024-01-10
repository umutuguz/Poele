package com.umut.poele.util

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.umut.poele.R
import com.umut.poele.ui.base.BaseAdapter
import com.umut.poele.util.extension.toText
import java.time.LocalDate

@BindingAdapter("setUrl")
fun setUrl(imageView: ImageView, url: String?){
    url?.let {
        val uri =url.toUri().buildUpon().scheme("https").build()
        imageView.load(uri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("setAdapter")
fun setAdapter(
    recyclerView: RecyclerView, adapter: BaseAdapter<ViewDataBinding, Any>?
) {
    adapter?.let {
        recyclerView.adapter = it
    }
}

@BindingAdapter("setIntText")
fun setIntText(textView: TextView, number: Number?) {
    when (number) {
        null -> {
            textView.text = ""
        }
        -1 -> {
            textView.text = "Undetermined"
        }
        else -> {
            textView.text = number.toString()
        }
    }
}

@BindingAdapter("setState")
fun setState(textView: TextView, state: States?) {
    textView.text = state?.toText() ?: ""
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
    textView.text = level?.toText() ?: ""
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
    val unitString = unit.toText()
    val amountString = amount.toText()

    textView.text = amountString + " " + unitString
}

@BindingAdapter("setMenu")
fun setMenu(textView: TextView, mealTitle: Meals?){
    if (mealTitle == null) {
        textView.text = ""
    }else
    {
        textView.text = mealTitle.toText()
    }
}

@BindingAdapter("setPrepTime")
fun setPrepTime(textView: TextView, time: Int?) {
    when (time) {
        -1 -> textView.text = "Prep Time: Unstated"
        else -> textView.text = "Prep Time: $time min"

    }
}
