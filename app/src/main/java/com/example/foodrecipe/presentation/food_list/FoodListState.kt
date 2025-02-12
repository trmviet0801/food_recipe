package com.example.foodrecipe.presentation.food_list

import androidx.compose.runtime.Immutable

@Immutable
data class FoodListState(
    val isLoading: Boolean = false,
)
