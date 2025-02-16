package com.example.foodrecipe.presentation.food_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodrecipe.domain.RecipeDatasource
import com.example.foodrecipe.domain.util.onError
import com.example.foodrecipe.domain.util.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FoodListViewModel(
    private val recipeDatasource: RecipeDatasource
): ViewModel() {
    private val _state = MutableStateFlow(FoodListState())
//    val state = _state
//        .onStart {
//            loadRecipes()
//        }
//        .stateIn(
//            viewModelScope,
//            SharingStarted.WhileSubscribed(5000L),
//            FoodListState()
//        )
    val state = _state.asStateFlow()
    init {
        loadRecipes()
    }

    private fun loadRecipes() {
        viewModelScope.launch {
            _state.update { it.copy(
                isLoading = true
            ) }
            recipeDatasource
                .getRecipes()
                .onError { error ->
                    Log.e("Network Error", "${error.name}")
                    _state.update { it.copy(
                        isLoading = false
                    ) }
                }
                .onSuccess { data ->
                _state.update { it.copy(
                    foodRecipes = data,
                    isLoading = false
                ) }

            }
        }
    }
}