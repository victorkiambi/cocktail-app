package com.main.cocktailapp.domain.use_case // ktlint-disable package-name

import com.main.cocktailapp.core.util.Resource
import com.main.cocktailapp.data.local.remote.dto.CocktailDto
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
