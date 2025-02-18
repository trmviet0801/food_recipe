package com.example.foodrecipe.presentation.food_list

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.example.foodrecipe.presentation.food_detail.FoodDetailScreen
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

    if (state.value.selectedRecipe == null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp)
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        localFocusManager.clearFocus()
                    })
                }
        ) {
            SearchBox(state.value.searchKeyword) { keyword ->
                viewModel.onAction(FoodListAction.OnSearching(keyword))
            }
            FlowRow(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.Center
            ) {
                if (state.value.isLoading)
                    CircularProgressIndicator()
                state.value.foodRecipes.filter { it.strMealThumb.contains("http") }.map { recipe ->
                    FoodListItem(recipe = recipe, onClick = {
                        viewModel.onAction(FoodListAction.OnRecipeClick(recipe))
                    })
                }
            }
        }
    } else {
        FoodDetailScreen(state.value.selectedRecipe!!, onAction = {
            viewModel.onAction(FoodListAction.OnReturnMainScreen)
        })
    }
}
