package com.example.foodrecipe.core.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class FoodRecipeResponseDto(
    val meals: List<FoodRecipeDto>
)
