package com.umut.poele.model

import android.os.Parcelable
import com.umut.poele.ui.base.ListAdapterItem
import com.umut.poele.util.States
import com.umut.poele.util.Units
import kotlinx.parcelize.Parcelize
import java.time.LocalDate
import java.util.Date

typealias ImageUrl = Int

@Parcelize
data class Supply(
    val id: Int,
    val title: String,
    val imageUrl: ImageUrl,
    val category: String,
    val amount: Double,
    val unit: Units,
    val macro: Macro,
    var state: States,
    val date: LocalDate,
    val averageGML: Int?
) : ListAdapterItem, Parcelable
