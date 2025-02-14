package com.example.foodrecipe.domain

import com.example.foodrecipe.domain.util.NetworkError
import com.example.foodrecipe.domain.util.Result

interface RecipeDatasource {
    suspend fun getRecipes(): Result<List<FoodRecipe>, NetworkError>
    suspend fun getRecipesByIngredient(ingredient: String): Result<List<FoodRecipe>, NetworkError>
}