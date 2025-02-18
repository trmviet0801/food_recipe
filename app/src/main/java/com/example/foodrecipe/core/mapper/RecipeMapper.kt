package com.example.foodrecipe.core.mapper

import com.example.foodrecipe.core.data.dto.FoodRecipeDto
import com.example.foodrecipe.domain.FoodRecipe
import kotlin.reflect.full.declaredMemberProperties

fun FoodRecipeDto.toFoodRecipe(): FoodRecipe {
    val ingredients: List<String> =
        convertPropertiesToList<String, FoodRecipeDto>("strIngredient", this)
    val measures: List<String> =
        convertPropertiesToList<String, FoodRecipeDto>("strMeasure", this)

    return FoodRecipe(
        idMeal = idMeal,
        strMeal = strMeal,
        strCategory = strCategory,
        strArea = strArea,
        strInstructions = strInstructions,
        strMealThumb = strMealThumb.toString(),
        strYoutube = strYoutube,
        strIngredients = ingredients,
        strMeasures = measures
    )
}

private inline fun <T, reified D : Any> convertPropertiesToList(
    property: String,
    instance: D
): List<T> {
    return (1..D::class.members.size).mapNotNull { index ->
        D::class.declaredMemberProperties.firstOrNull { it ->
            it.name.equals("$property$index")
        }?.get(instance) as? T
    }
}