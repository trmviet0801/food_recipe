package com.example.foodrecipe.presentation.food_list

import com.example.foodrecipe.domain.FoodRecipe

sealed interface FoodListAction {
    data class OnRecipeClick(val recipe: FoodRecipe): FoodListAction
    data object OnReturnMainScreen: FoodListAction
    data class OnSearching(val keyword: String): FoodListAction
    data object BackToMainScreen: FoodListAction
}