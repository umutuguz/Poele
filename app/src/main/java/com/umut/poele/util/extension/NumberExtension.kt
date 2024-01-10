package com.umut.poele.util.extension

import java.math.RoundingMode
import java.text.DecimalFormat

fun Double.toText() : String {
    val string = this.toString()
    val integer: Long = string.split(".").first().toLong()
    val decimal: Long = string.split(".").last().toLong()
    val decimalFormat = DecimalFormat("#.##")
    decimalFormat.roundingMode = RoundingMode.CEILING

    return if (decimal == 0L) {
        integer.toString()
    } else {
        decimalFormat.format(this)
    }
}
