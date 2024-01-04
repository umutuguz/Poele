package com.umut.poele.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.util.extension.toLevel

@Entity(tableName = "shoplist")
data class ShopListEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("recipe_title")
    val recipeTitle: String,
    @ColumnInfo("image_url")
    val imageUrl: String,
    @ColumnInfo("prep_time")
    val prepTime: Int,
    @ColumnInfo("servings")
    val servings: Int,
    @ColumnInfo("difficulty_level")
    val difficultyLevel: String,
    @ColumnInfo("chef_name")
    val chefName: String
)

fun ShopListEntity.toRecipeBasic() : RecipeBasic {
    return RecipeBasic(
        id,
        recipeTitle,
        imageUrl,
        chefName,
        prepTime = prepTime,
        servings = servings,
        difficultyLevel = difficultyLevel.toLevel()
    )
}
