package com.example.foodrecipe.presentation.food_list

import androidx.compose.runtime.Immutable
import com.example.foodrecipe.domain.FoodRecipe

@Immutable
data class FoodListState(
    val isLoading: Boolean = false,
    val foodRecipes: List<FoodRecipe> = emptyList<FoodRecipe>(),
    val selectedRecipe: FoodRecipe? = null,
    val isShowingIngredientCart: Boolean = false
)
