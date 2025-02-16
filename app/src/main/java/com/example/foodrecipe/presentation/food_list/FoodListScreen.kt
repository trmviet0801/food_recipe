package com.example.foodrecipe.presentation.food_list

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.presentation.food_list.components.FoodListItem
import com.example.foodrecipe.presentation.food_list.components.SearchBox

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FoodListScreen(
    modifier: Modifier = Modifier,
    viewModel: FoodListViewModel
) {
    val state = viewModel.state.collectAsState()
    val localFocusManager = LocalFocusManager.current
    Column (
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
        FlowRow (
            modifier = Modifier
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            state.value.foodRecipes.map { recipe ->
                FoodListItem(recipe = recipe)
            }
        }
    }
}
