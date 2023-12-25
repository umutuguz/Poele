package com.umut.poele.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.umut.poele.domain.model.ImageUrl

@Entity(tableName = "recipe")
data class RecipeEntity(
    @PrimaryKey @ColumnInfo("recipe_id") val id: Int,
    @ColumnInfo("title") val title: String,
    @ColumnInfo("image_url") val imageUrl: ImageUrl,
    @ColumnInfo("chef_name") val chefName: String,
    @ColumnInfo("description") val description: String,
    @ColumnInfo("prep_time") val prepTime: Int,
    @ColumnInfo("servings") val servings: Int,
    @ColumnInfo("difficulty_level") val difficultyLevel: String,
    @ColumnInfo("is_favorite") val isFavorite: Boolean,
    @ColumnInfo("is_vegan") val isVegan: Boolean,
)

//class CategoryConverter{
//
//    @TypeConverter
//    fun categoryToString(category: Category): String {
//        return category.toString()
//    }
//}
