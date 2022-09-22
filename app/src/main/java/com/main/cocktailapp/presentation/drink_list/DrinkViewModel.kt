package com.main.cocktailapp.presentation.drink_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.main.cocktailapp.core.util.Resource
import com.main.cocktailapp.domain.use_case.GetDrinksUseCase
import com.main.cocktailapp.presentation.DrinkState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DrinkViewModel @Inject constructor(
    private val getDrinksUseCase: GetDrinksUseCase
) : ViewModel() {

    private val _state = mutableStateOf(DrinkState())
    val state: State<DrinkState> = _state

    init {
        onEvent()
    }

    private fun onEvent() {
        getDrinksUseCase().onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value = DrinkState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = DrinkState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = DrinkState(
                        drinkItems = result.data
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}
