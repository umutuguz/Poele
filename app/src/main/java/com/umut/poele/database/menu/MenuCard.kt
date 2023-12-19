package com.umut.poele.database.menu

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "menu_card")
data class MenuCard(
    @PrimaryKey @ColumnInfo("menu_card_id") val id: Int,
    @ColumnInfo("user_email") val userEmail: String,
    @ColumnInfo("chef_name") val chefName: String,
    @ColumnInfo("primary_meal_breakfast") val primaryMealBreakfast: String,
    @ColumnInfo("secondary_meal_breakfast") val secondaryMealBreakfast: String,
    @ColumnInfo("tertiary_meal_breakfast") val tertiaryMealBreakfast: String,
    @ColumnInfo("primary_meal_brunch") val primaryMealBrunch: String,
    @ColumnInfo("secondary_meal_brunch") val secondaryMealBrunch: String,
    @ColumnInfo("tertiary_meal_brunch") val tertiaryMealBrunch: String,
    @ColumnInfo("primary_meal_lunch") val primaryMealLunch: String,
    @ColumnInfo("secondary_meal_lunch") val secondaryMealLunch: String,
    @ColumnInfo("tertiary_meal_lunch") val tertiaryMealLunch: String,
    @ColumnInfo("primary_meal_dinner") val primaryMealDinner: String,
    @ColumnInfo("secondary_meal_dinner") val secondaryMealDinner: String,
    @ColumnInfo("tertiary_meal_dinner") val tertiaryMealDinner: String,
    @ColumnInfo("user_id") val userId: Int,
)
