package com.main.cocktailapp.data.local.remote

import com.main.cocktailapp.data.local.remote.dto.CocktailDto
import com.main.cocktailapp.data.local.remote.dto.DrinkDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailsApi {
    @GET("popular.php")
    suspend fun getPopularCocktails(): CocktailDto

    @GET("popular.php")
    suspend fun getCocktailByIngredient(@Query("i") ingredient: String): List<DrinkDto>
}
