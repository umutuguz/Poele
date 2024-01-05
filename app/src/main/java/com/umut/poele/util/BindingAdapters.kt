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
import java.time.LocalDate

@BindingAdapter("setImage")
fun setImage(imageView: ImageView, imageId: Int) {
    imageView.setImageResource(imageId)
}

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
fun setState(textView: TextView, state: States) {
    when (state) {
        States.UNUSED -> textView.text = "Unused"
        States.USED -> textView.text = "Used"
        States.UNDETERMINED -> textView.text = "Undetermined"
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
        Levels.UNDETERMINED -> textView.text = "Unterdetermined"

        else -> {textView.text = ""}
    }
}

@BindingAdapter("setDifficultyLevelString")
fun setDifficultyLevelString(textView: TextView, level: Levels?) {
    when (level) {
        Levels.EASY -> textView.text = "Easy"
        Levels.INTERMEDIATE -> textView.text = "Intermediate"
        Levels.HARD -> textView.text = "Hard"
        Levels.UNDETERMINED -> textView.text = "Unterdetermined"

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
        Units.CUP -> "cups"
        Units.PINCH -> "pinches"
        Units.PIECE -> "pieces"
        Units.CLOVES -> "cloves"
        Units.SERVINGS -> "servings"
        Units.UNDETERMINED -> ""
    }
    var result = 0
    val amountString1 = amount.toString()
    val intAmount = amountString1.split(".").first().toInt()
    val decimalAmount = amountString1.split(".").last().toInt()
    if (decimalAmount == 0) {
        result = intAmount
        textView.text = "Amount: $result $unitString"
    }

    val amountString = when (amount) {
        -1.0 -> "Undetermined"
        else -> amount.toString()
    }
    textView.text = "Amount: $amountString $unitString"
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
            Meals.UNDETERMINED -> textView.text = "Undetermined"
        }
    }
}

@BindingAdapter("setPrepTime")
fun setPrepTime(textView: TextView, time: Int?) {
    when (time) {
        -1 -> textView.text = "Prep Time: Unstated"
        else -> textView.text = "Prep Time: $time min"

    }
}
