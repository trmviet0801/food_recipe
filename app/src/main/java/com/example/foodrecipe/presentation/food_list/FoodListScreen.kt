package com.example.foodrecipe.presentation.food_list

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.presentation.food_list.components.SearchBox
import com.example.foodrecipe.ui.theme.FoodRecipeTheme

@Composable
fun FoodListScreen(
    modifier: Modifier = Modifier
) {
    val localFocusManager = LocalFocusManager.current
    Box (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    localFocusManager.clearFocus()
                })
            }
    ) {
        SearchBox { it ->
            TODO()
        }
    }
}

@PreviewLightDark
@Composable
private fun FoodListScreenPreview() {
    FoodRecipeTheme {
        FoodListScreen()
    }
}