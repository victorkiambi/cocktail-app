package com.main.cocktailapp.data.repository

import android.util.Log
import com.main.cocktailapp.core.util.Resource
import com.main.cocktailapp.data.local.DrinkDao
import com.main.cocktailapp.data.local.remote.CocktailsApi
import com.main.cocktailapp.data.local.remote.dto.CocktailDto
import com.main.cocktailapp.domain.Drink
import com.main.cocktailapp.domain.repository.DrinkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class DrinkRepositoryImpl(
    private val api: CocktailsApi,
    private val dao: DrinkDao
) : DrinkRepository {
    override fun getPopularDrinks(): Flow<Resource<List<Drink>>> = flow {
//        emit(Resource.Loading())
//        val drinks = dao.getDrinks().map { it.toDrink() }
//        emit(Resource.Loading(data = drinks))

        try {
            emit(Resource.Loading())
            val remoteDrinks = api.getPopularCocktails()
            emit(Resource.Success(data = remoteDrinks.drinks.map { it.toDrink() }))
//            dao.deleteDrinks()
//            dao.insertDrink(remoteDrinks.map { it.toDrinkEntity() })
        } catch (e: HttpException) {
            Log.e("Error", e.toString())
            emit(
                Resource.Error(
                    message = "Oops something went wrong"
//                    data = drinks
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Oops couldn't reach server, check internet connection"
//                    data = drinks
                )
            )
        }
//        val newData = dao.getDrinks().map { it.toDrink() }
//        Log.e("DETAILS", newData.toString())
//        emit(Resource.Success(newData))
    }
}
