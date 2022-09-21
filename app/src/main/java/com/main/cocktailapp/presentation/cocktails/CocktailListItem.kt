package com.main.cocktailapp.presentation.cocktails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.main.cocktailapp.domain.Drink

@Composable
fun CocktailListItem(item: Drink) {
    CocktailListItemCard(item)
}

@Composable
fun CocktailListItemCard(item: Drink) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = Modifier.padding(10.dp),
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

@Preview
@Composable
fun CocktailListItemScreenPreview() {
    CocktailListItem(
        item = Drink(
            idDrink = "",
            strAlcoholic = "",
            strCategory = "",
            strDrink = "Mojito",
            strGlass = "",
            strImageAttribution = "",
            strIngredient1 = "",
            strIngredient2 = "",
            strIngredient3 = "",
            strIngredient4 = "",
            strIngredient5 = "",
            strIngredient6 = "",
            strInstructions = "",
            strDrinkThumb = "https://www.thecocktaildb.com/images/media/drink/vrwquq1478252802.jpg"
        )
    )
}
