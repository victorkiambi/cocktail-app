package com.main.cocktailapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.main.cocktailapp.domain.Drink
import com.main.cocktailapp.presentation.destinations.DrinkDestination
import com.main.cocktailapp.presentation.drink.DrinkModel
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun DrinkListItem(item: Drink, navController: DestinationsNavigator) {
    DrinkListItemCard(item, navController)
}

@Composable
fun DrinkListItemCard(item: Drink, navController: DestinationsNavigator) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = Modifier.padding(10.dp).clickable {
            navController.navigate(
                DrinkDestination(
                    DrinkModel(
                        idDrink = item.idDrink,
                        strAlcoholic = item.strAlcoholic,
                        strCategory = item.strCategory,
                        strDrink = item.strDrink,
                        strGlass = item.strGlass,
                        strDrinkThumb = item.strDrinkThumb,
                        strImageAttribution = item.strImageAttribution,
                        strIngredient1 = item.strIngredient1,
                        strIngredient2 = item.strIngredient2,
                        strIngredient3 = item.strIngredient3,
                        strIngredient4 = item.strIngredient4,
                        strIngredient5 = item.strIngredient5,
                        strIngredient6 = item.strIngredient6,
                        strInstructions = item.strInstructions
                    )
                )
            )
        },
        shape = RoundedCornerShape(15.dp)
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = rememberAsyncImagePainter(item.strDrinkThumb),
                contentDescription = "gin",
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = item.strDrink,
                    color = Color.White
                )
            }
        }
    }
}

// @Preview
// @Composable
// fun DrinkListItemScreenPreview() {
//    DrinkListItem(
//        item = Drink(
//            idDrink = "",
//            strAlcoholic = "",
//            strCategory = "",
//            strDrink = "Mojito",
//            strGlass = "",
//            strImageAttribution = "",
//            strIngredient1 = "",
//            strIngredient2 = "",
//            strIngredient3 = "",
//            strIngredient4 = "",
//            strIngredient5 = "",
//            strIngredient6 = "",
//            strInstructions = "",
//            strDrinkThumb = "https://www.thecocktaildb.com/images/media/drink/vrwquq1478252802.jpg"
//        ),
//        navController = rememberNavController()
//    )
// }
