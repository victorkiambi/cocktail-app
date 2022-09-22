package com.main.cocktailapp.presentation.drink

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DrinkModel(
    val idDrink: String,
    val strAlcoholic: String,
    val strCategory: String,
    val strDrink: String,
    val strGlass: String,
    val strImageAttribution: String?,
    val strIngredient1: String?,
    val strIngredient2: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,
    val strIngredient6: String?,
    val strInstructions: String,
    val strDrinkThumb: String
) : Parcelable
