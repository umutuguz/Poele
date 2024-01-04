package com.umut.poele.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Equipment(
    val title: String = ""
) : Parcelable
