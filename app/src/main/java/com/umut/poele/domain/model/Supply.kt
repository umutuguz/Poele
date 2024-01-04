package com.umut.poele.domain.model

import android.os.Parcelable
import com.umut.poele.util.States
import com.umut.poele.util.Units
import kotlinx.parcelize.Parcelize
import java.time.LocalDate

typealias ImageUrl = Int

@Parcelize
data class Supply(
    val id: Int = -1,
    val title: String = "",
    val imageUrl: String = "",
    val category: String = "",
    var amount: Double = -1.0,
    var unit: Units = Units.UNDETERMINED,
    val macro: Macro = Macro(),
    var state: States = States.UNUSED,
    var date: LocalDate = LocalDate.now(),
    val averageGML: Int? = null
) : Parcelable

fun String.toLocalDate() : LocalDate {
    val date = this.split("-")
    return if (date.size == 3) {
        LocalDate.of(date.first().toInt(), date[1].toInt(), date.last().toInt())
    } else {
        LocalDate.now()
    }
}

fun String.toUnit(): Units {
    return when (this) {
        "tbsp" -> Units.TABLESPOON
        "piece" -> Units.PIECE
        "gram" -> Units.GRAM
        "tablespoon" -> Units.TABLESPOON
        "tsp" -> Units.TEASPOON
        "teaspoon" -> Units.TEASPOON
        "dsp" -> Units.DESSERTSPOON
        "dessertspoon" -> Units.DESSERTSPOON
        "cups" -> Units.CUP
        "cup" -> Units.CUP
        "ml" -> Units.ML
        "cloves" -> Units.CLOVES
        "clove" -> Units.CLOVES
        "pinches" -> Units.PINCH
        "pinch" -> Units.PINCH
        "ounces" -> Units.GRAM
        "servings" -> Units.SERVINGS
        "serving" -> Units.SERVINGS
        else -> Units.UNDETERMINED
    }
}

fun String.toState() : States {
    return when (this) {
        "UNUSED" -> States.UNUSED
        "USED" -> States.USED
        else -> States.UNDETERMINED
    }
}
