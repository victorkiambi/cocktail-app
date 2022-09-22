package com.main.cocktailapp.presentation.drink

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun Drink(drink: DrinkModel) {
    DrinkScreen(drink)
}

@Composable
fun DrinkScreen(drink: DrinkModel) {
    Text(text = drink.idDrink)
}

@Preview
@Composable
fun DrinkScreenPreview() {
    DrinkScreen(
        drink = DrinkModel(
            idDrink = "",
            strAlcoholic = "",
            strCategory = "",
            strDrink = "",
            strGlass = "",
            strImageAttribution = null,
            strIngredient1 = null,
            strIngredient2 = null,
            strIngredient3 = null,
            strIngredient4 = null,
            strIngredient5 = null,
            strIngredient6 = null,
            strInstructions = "",
            strDrinkThumb = ""
        )
    )
}
