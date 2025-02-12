package com.example.foodrecipe.domain

data class FoodRecipe(
    val idMeal: String,
    val strMeal: String,
    val strDrinkAlternate: String? = null,
    val strCategory: String,
    val strArea: String,
    val strInstructions: String,
    val strMealThumb: String,
    val strTags: List<String>,
    val strYoutube: String?,
    val strIngredients: List<String?>,
    val strMeasures: List<String?>,
)
