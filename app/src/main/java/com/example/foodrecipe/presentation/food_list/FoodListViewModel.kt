package com.example.foodrecipe.presentation.food_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodrecipe.domain.RecipeDatasource
import com.example.foodrecipe.domain.util.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FoodListViewModel(
    private val recipeDatasource: RecipeDatasource
): ViewModel() {
    private val _state = MutableStateFlow(FoodListState())
    val state = _state
        .onStart {
            loadRecipes()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            FoodListState()
        )

    private fun loadRecipes() {
        viewModelScope.launch {
            recipeDatasource.getRecipes().onSuccess { data -> Log.d("data", data.toString()) }
        }
    }
}