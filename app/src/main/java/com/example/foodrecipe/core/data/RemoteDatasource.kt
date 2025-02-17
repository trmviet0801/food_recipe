package com.example.foodrecipe.core.data

import com.example.foodrecipe.BuildConfig
import com.example.foodrecipe.core.data.dto.FoodRecipeResponseDto
import com.example.foodrecipe.core.mapper.toFoodRecipe
import com.example.foodrecipe.core.networking.safeCall
import com.example.foodrecipe.domain.FoodRecipe
import com.example.foodrecipe.domain.RecipeDatasource
import com.example.foodrecipe.domain.util.NetworkError
import com.example.foodrecipe.domain.util.Result
import com.example.foodrecipe.domain.util.map
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteDatasource(
    private val httpClient: HttpClient
): RecipeDatasource {
    override suspend fun getRecipes(): Result<List<FoodRecipe>, NetworkError> {
        return safeCall<FoodRecipeResponseDto> {
            httpClient.get(BuildConfig.RANDOM_URL)
        }.map { response ->
            response.meals.map { it -> it.toFoodRecipe() }
        }
    }

    override suspend fun getRecipesByIngredient(ingredient: String): Result<List<FoodRecipe>, NetworkError> {
        TODO("Not yet implemented")
    }

}