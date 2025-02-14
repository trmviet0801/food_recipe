package com.example.foodrecipe.domain

data class FoodRecipe(
    val idMeal: String,
    val strMeal: String,
    val strCategory: String,
    val strArea: String,
    val strInstructions: String,
    val strMealThumb: String,
    val strYoutube: String?,
    val strIngredients: List<String?>,
    val strMeasures: List<String?>,
)
