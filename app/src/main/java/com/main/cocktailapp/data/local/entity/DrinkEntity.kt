package com.main.cocktailapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.main.cocktailapp.domain.Drink

@Entity
data class DrinkEntity(
    @PrimaryKey val idDrink: String,
    val strAlcoholic: String,
    val strCategory: String,
    val strDrink: String,
    val strGlass: String,
    val strImageAttribution: String,
    val strIngredient1: String,
    val strIngredient2: String,
    val strIngredient3: String,
    val strIngredient4: String,
    val strIngredient5: String,
    val strIngredient6: String,
    val strInstructions: String,
    val strDrinkThumb: String

){
    fun toDrink(): Drink {
        return Drink(
            idDrink = idDrink,
            strAlcoholic = strAlcoholic,
            strCategory = strCategory,
            strDrink = strDrink,
            strGlass = strGlass,
            strImageAttribution = strImageAttribution,
            strIngredient1 = strIngredient1,
            strIngredient2 = strIngredient2,
            strIngredient3 = strIngredient3,
            strIngredient4 = strIngredient4,
            strIngredient5 = strIngredient5,
            strIngredient6 = strIngredient6,
            strInstructions = strInstructions,
            strDrinkThumb = strDrinkThumb

        )
    }
}
