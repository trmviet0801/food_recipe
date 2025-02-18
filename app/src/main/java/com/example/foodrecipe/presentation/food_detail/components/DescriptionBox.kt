package com.example.foodrecipe.presentation.food_detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.R
import com.example.foodrecipe.presentation.food_list.components.previewRecipe
import com.example.foodrecipe.ui.theme.FoodRecipeTheme

@Composable
fun DescriptionBox(description: String) {
    val formattedResponse = description
        .replace("\\n", "\n")
        .replace("\\r", "\r")
        .replace("\\t", "\t")
    Column {
        Text(
            text = stringResource(R.string.description),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = formattedResponse,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@PreviewLightDark
@Composable
private fun DescriptionBoxPreview() {
    FoodRecipeTheme {
        DescriptionBox(previewRecipe.strInstructions)
    }
}