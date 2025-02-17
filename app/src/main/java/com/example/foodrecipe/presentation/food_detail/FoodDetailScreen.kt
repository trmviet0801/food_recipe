package com.example.foodrecipe.presentation.food_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.foodrecipe.domain.FoodRecipe
import com.example.foodrecipe.presentation.food_detail.components.IngredientCart
import com.example.foodrecipe.presentation.food_list.components.previewRecipe
import com.example.foodrecipe.ui.theme.FoodRecipeTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FoodDetailScreen(
    recipe: FoodRecipe
) {
    FlowRow(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .padding(top = 30.dp)
            .verticalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.Center,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = recipe.strMealThumb,
            contentDescription = recipe.strMeal,
            modifier = Modifier
                .width(300.dp)
        )
        Column (
            modifier = Modifier
                .padding(16.dp)
                .width(300.dp)
        ) {
            Text(
                text = recipe.strMeal,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            FlowRow (
                modifier = Modifier
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                IngredientCart(
                    ingredients = recipe.strIngredients,
                    measurer = recipe.strMeasures,
                )
            }
        }
    }
}

@Composable
@PreviewLightDark
private fun FoodDetailScreenPreview() {
    FoodRecipeTheme {
        FoodDetailScreen(previewRecipe)
    }
}