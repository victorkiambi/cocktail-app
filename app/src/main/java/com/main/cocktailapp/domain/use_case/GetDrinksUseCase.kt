package com.main.cocktailapp.domain.use_case

import com.main.cocktailapp.core.util.Resource
import com.main.cocktailapp.domain.Drink
import com.main.cocktailapp.domain.repository.DrinkRepository
import kotlinx.coroutines.flow.Flow

class GetDrinksUseCase(
    private val repository: DrinkRepository
) {
    operator fun invoke(): Flow<Resource<List<Drink>>> {
        return repository.getPopularDrinks()
    }
}
