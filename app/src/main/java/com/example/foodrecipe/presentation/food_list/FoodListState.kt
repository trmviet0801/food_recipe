package com.example.foodrecipe.presentation.food_list

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.foodrecipe.domain.FoodRecipe

@Immutable
data class FoodListState(
    val isLoading: Boolean = false,
    val foodRecipes: List<FoodRecipe> = emptyList(),
    val selectedRecipe: FoodRecipe? = null,
    val isShowingIngredientCart: Boolean = false,
    val searchFoodRecipes: List<FoodRecipe?> = emptyList(),
    val searchKeyword: MutableState<String> = mutableStateOf("")
)
