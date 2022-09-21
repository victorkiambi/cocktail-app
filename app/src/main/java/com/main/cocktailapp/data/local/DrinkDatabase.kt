package com.main.cocktailapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.main.cocktailapp.data.local.entity.DrinkEntity

@Database(
    entities = [DrinkEntity::class],
    version = 1
)
abstract class DrinkDatabase : RoomDatabase() {
    abstract val dao: DrinkDao
}
