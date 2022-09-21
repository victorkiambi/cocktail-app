package com.main.cocktailapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.main.cocktailapp.data.local.entity.DrinkEntity

@Dao
interface DrinkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrink(drink: List<DrinkEntity>)

    @Query("select * from drinkentity")
    suspend fun getDrinks(): List<DrinkEntity>

    @Query("DELETE FROM drinkentity")
    suspend fun deleteDrinks()
}
