package com.umut.poele.data.source.local

import android.content.Context
import android.util.Log
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.umut.poele.R
import com.umut.poele.data.source.local.entity.AddressEntity
import com.umut.poele.data.source.local.entity.AmountEntity
import com.umut.poele.data.source.local.entity.RecipeCategoryEntity
import com.umut.poele.data.source.local.entity.SupplyCategoryEntity
import com.umut.poele.data.source.local.entity.CuisineEntity
import com.umut.poele.data.source.local.entity.DirectionEntity
import com.umut.poele.data.source.local.entity.EquipmentEntity
import com.umut.poele.data.source.local.entity.MacroEntity
import com.umut.poele.data.source.local.entity.MenuCardEntity
import com.umut.poele.data.source.local.entity.RecipeEntity
import com.umut.poele.data.source.local.entity.SupplyEntity
import com.umut.poele.data.source.local.entity.UserEntity
import com.umut.poele.data.source.local.relation.RecipeCategoryCrossRef
import com.umut.poele.data.source.local.relation.RecipeCuisineCrossRef
import com.umut.poele.data.source.local.relation.RecipeEquipmentCrossRef
import com.umut.poele.data.source.local.relation.RecipeSupplyCrossRef
import com.umut.poele.data.source.local.relation.SupplyCategoryCrossRef
import com.umut.poele.data.source.local.relation.UserRecipeCrossRef
import com.umut.poele.data.source.local.relation.UserSupplyCrossRef
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray

class PrepopulateRoomCallback(private val context: Context) : RoomDatabase.Callback() {

    // I called it in onCreate because of called when the database is created for the first time.
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        CoroutineScope(Dispatchers.IO).launch {
            Log.i("Database", "dispatcher")

            prePopulateData(context)
        }
    }

//    override fun onOpen(db: SupportSQLiteDatabase) {
//        super.onOpen(db)
//        CoroutineScope(Dispatchers.IO).launch {
//            Log.i("Database", "dispatcher")
//
//            prePopulateData(context)
//        }
//    }

    private suspend fun prePopulateData(context: Context) {
        try {
            Log.i("Database", "prePopulateData")

            val userDao = AppDatabase.getDatabase(context).userDao()
            val recipeDao = AppDatabase.getDatabase(context).recipeDao()
            val supplyDao = AppDatabase.getDatabase(context).supplyDao()

            val menuCardList: JSONArray = context.resources.openRawResource(R.raw.menu_card).bufferedReader().use {
                JSONArray(it.readText())
            }
            val addressList: JSONArray = context.resources.openRawResource(R.raw.address).bufferedReader().use {
                JSONArray(it.readText())
            }
            val recipeList: JSONArray = context.resources.openRawResource(R.raw.recipe).bufferedReader().use {
                JSONArray(it.readText())
            }
            val supplyList: JSONArray = context.resources.openRawResource(R.raw.supply).bufferedReader().use {
                JSONArray(it.readText())
            }
            val userList: JSONArray = context.resources.openRawResource(R.raw.user).bufferedReader().use {
                JSONArray(it.readText())
            }
            val recipeCategoryList: JSONArray = context.resources.openRawResource(R.raw.recipe_category).bufferedReader().use {
                JSONArray(it.readText())
            }
            val supplyCategoryList: JSONArray = context.resources.openRawResource(R.raw.supply_category).bufferedReader().use {
                JSONArray(it.readText())
            }
            val cuisineList: JSONArray = context.resources.openRawResource(R.raw.cuisine).bufferedReader().use {
                JSONArray(it.readText())
            }
            val directionList: JSONArray = context.resources.openRawResource(R.raw.direction).bufferedReader().use {
                JSONArray(it.readText())
            }
            val equipmentList: JSONArray = context.resources.openRawResource(R.raw.equipment).bufferedReader().use {
                JSONArray(it.readText())
            }
            val macroList: JSONArray = context.resources.openRawResource(R.raw.macro).bufferedReader().use {
                JSONArray(it.readText())
            }
            val amountList: JSONArray = context.resources.openRawResource(R.raw.amount).bufferedReader().use {
                JSONArray(it.readText())
            }
            val userSupplyCrossRefList: JSONArray = context.resources.openRawResource(R.raw.user_supply_cross_ref).bufferedReader().use {
                JSONArray(it.readText())
            }
            val userRecipeCrossRefList: JSONArray = context.resources.openRawResource(R.raw.user_recipe_cross_ref).bufferedReader().use {
                JSONArray(it.readText())
            }
            val supplyCategoryCrossRefList: JSONArray = context.resources.openRawResource(R.raw.supply_category_cross_ref).bufferedReader().use {
                JSONArray(it.readText())
            }
            val recipeCategoryCrossRefList: JSONArray = context.resources.openRawResource(R.raw.recipe_category_cross_ref).bufferedReader().use {
                JSONArray(it.readText())
            }
            val recipeCuisineCrossRefList: JSONArray = context.resources.openRawResource(R.raw.recipe_cuisine_cross_ref).bufferedReader().use {
                JSONArray(it.readText())
            }
            val recipeEquipmentCrossRefList: JSONArray = context.resources.openRawResource(R.raw.recipe_equipment_cross_ref).bufferedReader().use {
                JSONArray(it.readText())
            }
            val recipeSupplyCrossRefList: JSONArray = context.resources.openRawResource(R.raw.recipe_supply_cross_ref).bufferedReader().use {
                JSONArray(it.readText())
            }

            menuCardList.takeIf { it.length() > 0 }?.let { list ->
                for (index in 0 until list.length()) {
                    val obj = list.getJSONObject(index)
                    userDao.upsertMenuCard(
                        MenuCardEntity(
                            obj.getInt("menu_card_id"),
                            obj.getString("user_email"),
                            obj.getString("chef_name"),
                            obj.getString("primary_meal_breakfast"),
                            obj.getString("secondary_meal_breakfast"),
                            obj.getString("tertiary_meal_breakfast"),
                            obj.getString("primary_meal_brunch"),
                            obj.getString("secondary_meal_brunch"),
                            obj.getString("tertiary_meal_brunch"),
                            obj.getString("primary_meal_lunch"),
                            obj.getString("secondary_meal_lunch"),
                            obj.getString("tertiary_meal_lunch"),
                            obj.getString("primary_meal_dinner"),
                            obj.getString("secondary_meal_dinner"),
                            obj.getString("tertiary_meal_dinner"),
                            obj.getInt("user_id")
                        )
                    )

                }
                Log.e("Database", "successfully pre-populated users into database")
            }

            addressList.takeIf { it.length() > 0 }?.let { list ->
                for (index in 0 until list.length()) {
                    val obj = list.getJSONObject(index)
                    userDao.upsertAddress(
                        AddressEntity(
                            obj.getInt("address_id"),
                            obj.getString("title"),
                            obj.getInt("address_image_url"),
                            obj.getString("city"),
                            obj.getString("district"),
                            obj.getString("neighborhood"),
                            obj.getString("street"),
                            obj.getString("building_name"),
                            obj.getInt("building_number"),
                            obj.getInt("floor_number"),
                            obj.getInt("door_number"),
                            obj.getInt("postal_code"),
                            obj.getInt("user_id")
                        )
                    )

                }
                Log.e("Database", "successfully pre-populated users into database")
            }

            userList.takeIf { it.length() > 0 }?.let { list ->
                for (index in 0 until list.length()) {
                    val obj = list.getJSONObject(index)
                    userDao.upsertUser(
                        UserEntity(
                            obj.getInt("user_id"),
                            obj.getString("email"),
                            obj.getString("password"),
                            obj.getString("first_name"),
                            obj.getString("last_name"),
                            obj.getString("phone")
                        )
                    )

                }
                Log.e("Database", "successfully pre-populated users into database")
            }



            recipeList.takeIf { it.length() > 0 }?.let { list ->
                for (index in 0 until list.length()) {
                    val obj = list.getJSONObject(index)
                    recipeDao.upsertRecipe(
                        RecipeEntity(
                            obj.getInt("recipe_id"),
                            obj.getString("title"),
                            obj.getInt("image_url"),
                            obj.getString("chef_name"),
                            obj.getString("description"),
                            obj.getInt("prep_time"),
                            obj.getInt("servings"),
                            obj.getString("difficulty_level"),
                            obj.getBoolean("is_favorite"),
                            obj.getBoolean("is_vegan")
                        )
                    )

                }
                Log.e("Database", "successfully pre-populated users into database")
            }

            recipeCategoryList.takeIf { it.length() > 0 }?.let { list ->
                for (index in 0 until list.length()) {
                    val obj = list.getJSONObject(index)
                    recipeDao.upsertRecipeCategory(
                        RecipeCategoryEntity(
                            obj.getString("recipe_category_title")
                        )
                    )

                }
                Log.e("Database", "successfully pre-populated users into database")
            }

            supplyCategoryList.takeIf { it.length() > 0 }?.let { list ->
                for (index in 0 until list.length()) {
                    val obj = list.getJSONObject(index)
                    supplyDao.upsertSupplyCategory(
                        SupplyCategoryEntity(
                            obj.getString("supply_category_title")
                        )
                    )

                }
                Log.e("Database", "successfully pre-populated users into database")
            }


            cuisineList.takeIf { it.length() > 0 }?.let { list ->
                for (index in 0 until list.length()) {
                    val obj = list.getJSONObject(index)
                    recipeDao.upsertCuisine(
                        CuisineEntity(
                            obj.getString("cuisine_title")
                        )
                    )

                }
                Log.e("Database", "successfully pre-populated users into database")
            }

            directionList.takeIf { it.length() > 0 }?.let { list ->
                for (index in 0 until list.length()) {
                    val obj = list.getJSONObject(index)
                    recipeDao.upsertDirection(
                        DirectionEntity(
                            obj.getInt("direction_id"),
                            obj.getString("first_direction"),
                            obj.getString("second_direction"),
                            obj.getString("third_direction"),
                            obj.getString("fourth_direction"),
                            obj.getString("fifth_direction"),
                            obj.getString("sixth_direction"),
                            obj.getString("seventh_direction"),
                            obj.getString("eighth_direction"),
                            obj.getString("ninth_direction"),
                            obj.getString("tenth_direction"),
                            obj.getInt("recipe_id")
                        )
                    )

                }
                Log.e("Database", "successfully pre-populated users into database")
            }

            equipmentList.takeIf { it.length() > 0 }?.let { list ->
                for (index in 0 until list.length()) {
                    val obj = list.getJSONObject(index)
                    recipeDao.upsertEquipment(
                        EquipmentEntity(
                            obj.getString("equipment_title")
                        )
                    )

                }
                Log.e("Database", "successfully pre-populated users into database")
            }

            macroList.takeIf { it.length() > 0 }?.let { list ->
                for (index in 0 until list.length()) {
                    val obj = list.getJSONObject(index)
                    supplyDao.upsertMacro(
                        MacroEntity(
                            obj.getInt("macro_id"),
                            obj.getDouble("fat"),
                            obj.getDouble("carb"),
                            obj.getDouble("fiber"),
                            obj.getDouble("protein"),
                            obj.getDouble("calorie"),
                            obj.getInt("supply_id")
                        )
                    )

                }
                Log.e("Database", "successfully pre-populated users into database")
            }

            supplyList.takeIf { it.length() > 0 }?.let { list ->
                for (index in 0 until list.length()) {
                    val obj = list.getJSONObject(index)
                    supplyDao.upsertSupply(
                        SupplyEntity(
                            obj.getInt("supply_id"),
                            obj.getString("title"),
                            obj.getInt("image_url"),
                            obj.getInt("average_g_ml")
                        )
                    )

                }
                Log.e("Database", "successfully pre-populated users into database")
            }

            amountList.takeIf { it.length() > 0 }?.let { list ->
                for (index in 0 until list.length()) {
                    val obj = list.getJSONObject(index)
                    supplyDao.upsertAmount(
                        AmountEntity(
                            obj.getInt("amount_id"),
                            obj.getDouble("amount"),
                            obj.getString("unit"),
                            obj.getString("state"),
                            obj.getString("date"),
                            obj.getInt("recipe_id"),
                            obj.getInt("user_id"),
                            obj.getInt("supply_id"),
                        )
                    )

                }
                Log.e("Database", "successfully pre-populated users into database")
            }

            userSupplyCrossRefList.takeIf { it.length() > 0 }?.let { list->
                for (index in 0 until list.length()){
                    val obj = list.getJSONObject(index)
                    userDao.upsertUserSupplyCrossRef(
                        UserSupplyCrossRef(
                            obj.getInt("user_id"),
                            obj.getInt("supply_id"),
                        )
                    )
                }
            }

            userRecipeCrossRefList.takeIf { it.length() > 0 }?.let { list->
                for (index in 0 until list.length()){
                    val obj = list.getJSONObject(index)
                    userDao.upsertUserRecipeCrossRef(
                        UserRecipeCrossRef(
                            obj.getInt("user_id"),
                            obj.getInt("recipe_id"),
                        )
                    )
                }
            }

           supplyCategoryCrossRefList.takeIf { it.length() > 0 }?.let { list->
                for (index in 0 until list.length()){
                    val obj = list.getJSONObject(index)
                    supplyDao.upsertSupplyCategoryCrossRef(
                        SupplyCategoryCrossRef(
                            obj.getInt("supply_id"),
                            obj.getString("supply_category_title"),
                        )
                    )
                }
            }

            recipeCategoryCrossRefList.takeIf { it.length() > 0 }?.let { list->
                for (index in 0 until list.length()){
                    val obj = list.getJSONObject(index)
                    recipeDao.upsertRecipeCategoryCrossRef(
                        RecipeCategoryCrossRef(
                            obj.getInt("recipe_id"),
                            obj.getString("recipe_category_title"),
                        )
                    )
                }
            }

            recipeCuisineCrossRefList.takeIf { it.length() > 0 }?.let { list->
                for (index in 0 until list.length()){
                    val obj = list.getJSONObject(index)
                    recipeDao.upsertRecipeCuisineCrossRef(
                        RecipeCuisineCrossRef(
                            obj.getInt("recipe_id"),
                            obj.getString("cuisine_title"),
                        )
                    )
                }
            }

            recipeEquipmentCrossRefList.takeIf { it.length() > 0 }?.let { list->
                for (index in 0 until list.length()){
                    val obj = list.getJSONObject(index)
                    recipeDao.upsertRecipeEquipmentCrossRef(
                        RecipeEquipmentCrossRef(
                            obj.getInt("recipe_id"),
                            obj.getString("equipment_title"),
                        )
                    )
                }
            }

            recipeSupplyCrossRefList.takeIf { it.length() > 0 }?.let { list->
                for (index in 0 until list.length()){
                    val obj = list.getJSONObject(index)
                    recipeDao.upsertRecipeSupplyCrossRef(
                        RecipeSupplyCrossRef(
                            obj.getInt("recipe_id"),
                            obj.getInt("supply_id"),
                        )
                    )
                }
            }

        } catch (exception: Exception) {
            Log.e(
                "Database", exception.localizedMessage ?: "failed to pre-populate users into database"
            )
        }
    }
}
