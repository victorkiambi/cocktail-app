package com.main.cocktailapp.domain.repository

import com.main.cocktailapp.core.util.Resource
import com.main.cocktailapp.domain.Drink
import kotlinx.coroutines.flow.Flow

interface DrinkRepository {
    fun getPopularDrinks(): Flow<Resource<List<Drink>>>
}