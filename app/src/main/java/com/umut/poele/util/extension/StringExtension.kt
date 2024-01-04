package com.umut.poele.util.extension

import com.umut.poele.util.Levels

fun String.empty() = ""

fun String.toLevel(): Levels {
    return when(this) {
        "EASY" -> Levels.EASY
        "INTERMEDIATE" -> Levels.INTERMEDIATE
        "HARD" -> Levels.HARD
        else -> Levels.UNDETERMINED
    }
}
