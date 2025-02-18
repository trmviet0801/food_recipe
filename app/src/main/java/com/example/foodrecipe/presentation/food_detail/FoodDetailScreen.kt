package com.example.foodrecipe.presentation.food_detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.LocalLifecycleOwner
import coil.compose.AsyncImage
import com.example.foodrecipe.R
import com.example.foodrecipe.domain.FoodRecipe
import com.example.foodrecipe.presentation.food_detail.components.DescriptionBox
import com.example.foodrecipe.presentation.food_detail.components.IngredientCart
import com.example.foodrecipe.presentation.food_detail.components.YoutubePlayer
import com.example.foodrecipe.presentation.food_list.components.previewRecipe
import com.example.foodrecipe.ui.theme.FoodRecipeTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FoodDetailScreen(
    recipe: FoodRecipe,
    onAction: () -> Unit
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
        Box(
            modifier = Modifier
                .clickable { onAction() }
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.left),
                contentDescription = stringResource(R.string.left_arrow),
                tint = MaterialTheme.colorScheme.primary
            )
        }
        AsyncImage(
            model = recipe.strMealThumb,
            contentDescription = recipe.strMeal,
            modifier = Modifier
                .width(300.dp)
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
                .width(300.dp)
        ) {
            Text(
                text = recipe.strMeal,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            FlowRow(
                modifier = Modifier
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                IngredientCart(
                    ingredients = recipe.strIngredients,
                    measurer = recipe.strMeasures,
                )
                DescriptionBox(recipe.strInstructions)
                when {
                    recipe.strYoutube?.contains("http") == true -> YoutubePlayer(
                        youtubeId = recipe.strYoutube,
                        LocalLifecycleOwner.current
                    )
                }
            }
        }
    }
}

@Composable
@PreviewLightDark
private fun FoodDetailScreenPreview() {
    FoodRecipeTheme {
        FoodDetailScreen(previewRecipe, {})
    }
}