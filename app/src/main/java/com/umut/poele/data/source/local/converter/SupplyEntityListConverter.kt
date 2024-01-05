package com.umut.poele.data.source.local.converter

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.umut.poele.data.source.local.entity.SupplyEntity
import com.umut.poele.domain.model.Supply

class SupplyEntityListConverter {

    @TypeConverter
    fun fromStringToSupplyList(value: String) : List<Supply>? =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
            .adapter<List<Supply>>(Types.newParameterizedType(List::class.java, Supply::class.java))
            .fromJson(value)

    @TypeConverter
    fun fromSupplyListTypeToString(supplyListType: List<Supply>?): String =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
            .adapter<List<Supply>>(Types.newParameterizedType(List::class.java, Supply::class.java))
            .toJson(supplyListType)

    @TypeConverter
    fun fromStringToSupplyEntityList(value: String): List<SupplyEntity>? =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build().adapter<List<SupplyEntity>>(
                Types.newParameterizedType(
                    List::class.java,
                    SupplyEntity::class.java
                )
            ).fromJson(value)

    @TypeConverter
    fun fromSupplyEntityListTypeToString(supplyEntityListType: List<SupplyEntity>?): String =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build().adapter<List<SupplyEntity>>(
                Types.newParameterizedType(
                    List::class.java,
                    SupplyEntity::class.java
                )
            ).toJson(supplyEntityListType)
}
