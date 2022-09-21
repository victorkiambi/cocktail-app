package com.main.cocktailapp.data.local.remote.dto

import com.main.cocktailapp.data.local.entity.DrinkEntity
import com.main.cocktailapp.domain.Drink

data class DrinkDto(
    val dateModified: String,
    val idDrink: String,
    val strAlcoholic: String,
    val strCategory: String,
    val strCreativeCommonsConfirmed: String,
    val strDrink: String,
    val strDrinkAlternate: String,
    val strDrinkThumb: String,
    val strGlass: String,
    val strIBA: String,
    val strImageAttribution: String,
    val strImageSource: String?,
    val strIngredient1: String,
    val strIngredient10: String,
    val strIngredient11: String,
    val strIngredient12: String,
    val strIngredient13: String,
    val strIngredient14: String,
    val strIngredient15: String,
    val strIngredient2: String,
    val strIngredient3: String,
    val strIngredient4: String,
    val strIngredient5: String,
    val strIngredient6: String,
    val strIngredient7: String,
    val strIngredient8: String,
    val strIngredient9: String,
    val strInstructions: String,
    val strInstructionsDE: String,
    val strInstructionsES: Any,
    val strInstructionsFR: Any,
    val strInstructionsIT: String,
    val strMeasure1: String,
    val strMeasure10: Any,
    val strMeasure11: Any,
    val strMeasure12: Any,
    val strMeasure13: Any,
    val strMeasure14: Any,
    val strMeasure15: Any,
    val strMeasure2: String,
    val strMeasure3: String,
    val strMeasure4: String,
    val strMeasure5: Any,
    val strMeasure6: Any,
    val strMeasure7: Any,
    val strMeasure8: Any,
    val strMeasure9: Any,
    val strTags: String,
    val strVideo: Any
) {
    fun toDrinkEntity(): DrinkEntity {
        return DrinkEntity(
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
