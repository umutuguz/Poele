package com.umut.poele.data.source.local

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
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
import com.umut.poele.data.source.local.dao.RecipeDao
import com.umut.poele.data.source.local.entity.SupplyEntity
import com.umut.poele.data.source.local.dao.SupplyDao
import com.umut.poele.data.source.local.entity.UserEntity
import com.umut.poele.data.source.local.dao.UserDao
import com.umut.poele.data.source.local.relation.RecipeCategoryCrossRef
import com.umut.poele.data.source.local.relation.RecipeCuisineCrossRef
import com.umut.poele.data.source.local.relation.RecipeEquipmentCrossRef
import com.umut.poele.data.source.local.relation.RecipeSupplyCrossRef
import com.umut.poele.data.source.local.relation.SupplyCategoryCrossRef
import com.umut.poele.data.source.local.relation.UserRecipeCrossRef
import com.umut.poele.data.source.local.relation.UserSupplyCrossRef

@Database(
    entities = [
        AddressEntity::class, AmountEntity::class, RecipeCategoryEntity::class, SupplyCategoryEntity::class,
        CuisineEntity::class, DirectionEntity::class, EquipmentEntity::class,
        MacroEntity::class, MenuCardEntity::class, RecipeEntity::class,
        SupplyEntity::class, UserEntity::class, UserSupplyCrossRef::class,
        UserRecipeCrossRef::class, SupplyCategoryCrossRef::class, RecipeCategoryCrossRef::class,
        RecipeCuisineCrossRef::class, RecipeEquipmentCrossRef::class, RecipeSupplyCrossRef::class],
    version = 1,
    exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun recipeDao(): RecipeDao
    abstract fun supplyDao(): SupplyDao


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
