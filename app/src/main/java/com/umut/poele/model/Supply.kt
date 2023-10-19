package com.umut.poele.model

import android.text.format.DateFormat
import com.umut.poele.ui.base.ListAdapterItem
import java.time.LocalDate
import java.util.Date

data class Supply(
    val id: Int,
    val name: String,
    val category: String,
    val amount: Double,
    val unit: String,
    val state: Boolean,
    val dateDay: Int,
    val dateMonth: Int,
    val dateYear: Int,
    ) : ListAdapterItem {

}

enum class Units(val unitName: String) {
    ML("ml"), GRAM("g"), TEASPOON("tsp"), TABLESPOON("tbsp"),
    DESSERTSPOON("dsp"), CUP("cup"), PINCH("pinch"), NUMBER("")
}

enum class States(val state: Boolean) {
    UNUSED(true), USED(false)
}
