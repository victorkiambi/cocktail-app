package com.main.cocktailapp.presentation

import com.main.cocktailapp.domain.Drink

data class DrinkState(
    val drinkItems: List<Drink>? = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
