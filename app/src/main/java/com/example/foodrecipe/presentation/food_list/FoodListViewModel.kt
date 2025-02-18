package com.example.foodrecipe.presentation.food_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodrecipe.domain.RecipeDatasource
import com.example.foodrecipe.domain.util.onError
import com.example.foodrecipe.domain.util.onSuccess
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FoodListViewModel(
    private val recipeDatasource: RecipeDatasource
) : ViewModel() {
    private val _state = MutableStateFlow(FoodListState())
    val state = _state.asStateFlow()

    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    private var searchJob: Job? = null

    init {
        loadRecipes()
    }


    private fun onKeywordChange(keyword: String, onSearch: (String) -> Unit) {
        if (keyword.isBlank()) {
            loadRecipes()
        } else {
            searchJob?.cancel()
            searchJob = coroutineScope.launch {
                delay(500)
                onSearch(keyword)
            }
        }
    }

    private fun loadRecipes() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }
            recipeDatasource
                .getRecipes()
                .onError { error ->
                    Log.e("Network Error", "${error.name}")
                    _state.update {
                        it.copy(
                            isLoading = false
                        )
                    }
                }
                .onSuccess { data ->
                    Log.d("FoodListViewModel", "data: ${data}")
                    _state.update {
                        it.copy(
                            foodRecipes = data,
                            isLoading = false
                        )
                    }

                }
        }
    }

    private fun searchRecipe(keyword: String) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }
            recipeDatasource
                .getRecipesByIngredient(keyword)
                .onError { error ->
                    Log.e("Network Error", "${error.name}")
                    _state.update {
                        it.copy(
                            isLoading = false
                        )
                    }
                }
                .onSuccess { data ->
                    Log.d("FoodListViewModel Search", "data: ${data}")
                    _state.update {
                        Log.d("Search", "data:  $data")
                        it.copy(
                            foodRecipes = data,
                            isLoading = false
                        )
                    }

                }
        }
    }

    private fun backToMainScreen() {
        _state.update {
            it.copy(
                selectedRecipe = null
            )
        }
    }

    fun onAction(action: FoodListAction) {
        when (action) {
            is FoodListAction.OnRecipeClick -> {
                _state.update {
                    it.copy(
                        selectedRecipe = action.recipe
                    )
                }
            }

            is FoodListAction.OnReturnMainScreen -> {
                _state.update {
                    it.copy(
                        selectedRecipe = null
                    )
                }
            }

            is FoodListAction.OnSearching -> {
                onKeywordChange(action.keyword) {
                    searchRecipe(keyword = action.keyword)
                }
            }

            FoodListAction.BackToMainScreen -> backToMainScreen()
        }
    }
}