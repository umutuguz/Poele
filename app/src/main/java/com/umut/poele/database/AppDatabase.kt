package com.umut.poele.database

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.umut.poele.database.address.Address
import com.umut.poele.database.address.AddressDao
import com.umut.poele.database.amount.Amount
import com.umut.poele.database.amount.AmountDao
import com.umut.poele.database.category.RecipeCategory
import com.umut.poele.database.category.RecipeCategoryDao
import com.umut.poele.database.category.SupplyCategory
import com.umut.poele.database.category.SupplyCategoryDao
import com.umut.poele.database.cuisine.Cuisine
import com.umut.poele.database.cuisine.CuisineDao
import com.umut.poele.database.direction.Direction
import com.umut.poele.database.direction.DirectionDao
import com.umut.poele.database.equipment.Equipment
import com.umut.poele.database.equipment.EquipmentDao
import com.umut.poele.database.macro.Macro
import com.umut.poele.database.macro.MacroDao
import com.umut.poele.database.menu.MenuCard
import com.umut.poele.database.menu.MenuCardDao
import com.umut.poele.database.recipe.Recipe
import com.umut.poele.database.recipe.RecipeDao
import com.umut.poele.database.relation.RecipeCategoryCrossRef
import com.umut.poele.database.relation.RecipeCuisineCrossRef
import com.umut.poele.database.relation.RecipeEquipmentCrossRef
import com.umut.poele.database.relation.RecipeSupplyCrossRef
import com.umut.poele.database.relation.SupplyCategoryCrossRef
import com.umut.poele.database.relation.UserRecipeCrossRef
import com.umut.poele.database.relation.UserSupplyCrossRef
import com.umut.poele.database.supply.Supply
import com.umut.poele.database.supply.SupplyDao
import com.umut.poele.database.user.User
import com.umut.poele.database.user.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [
        Address::class, Amount::class, RecipeCategory::class, SupplyCategory::class,
        Cuisine::class, Direction::class, Equipment::class,
        Macro::class, MenuCard::class, Recipe::class,
        Supply::class, User::class, UserSupplyCrossRef::class,
        UserRecipeCrossRef::class, SupplyCategoryCrossRef::class, RecipeCategoryCrossRef::class,
        RecipeCuisineCrossRef::class, RecipeEquipmentCrossRef::class, RecipeSupplyCrossRef::class],
    version = 1,
    exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun addressDao(): AddressDao
    abstract fun menuCardDao(): MenuCardDao
    abstract fun userDao(): UserDao
    abstract fun supplyDao(): SupplyDao
    abstract fun recipeDao(): RecipeDao
    abstract fun recipeCategoryDao(): RecipeCategoryDao
    abstract fun supplyCategoryDao(): SupplyCategoryDao
    abstract fun cuisineDao(): CuisineDao
    abstract fun directionDao(): DirectionDao
    abstract fun equipmentDao(): EquipmentDao
    abstract fun macroDao(): MacroDao
    abstract fun amountDao(): AmountDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            Log.i("Database", "Called Database ins: $INSTANCE")
            val instance = Room.databaseBuilder(
                context.applicationContext, AppDatabase::class.java, "poele_database"
            ).addCallback(PrepopulateRoomCallback(context)).build()
            return INSTANCE ?: synchronized(this) {
                INSTANCE = instance
                Log.i("Database", "After called Database ins: $INSTANCE")

                instance
            }
        }

    }
}
