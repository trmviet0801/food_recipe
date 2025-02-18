package com.example.foodrecipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.foodrecipe.presentation.food_list.FoodListAction
import com.example.foodrecipe.presentation.food_list.FoodListScreen
import com.example.foodrecipe.presentation.food_list.FoodListViewModel
import com.example.foodrecipe.ui.theme.FoodRecipeTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel by viewModel<FoodListViewModel>()
    var backPressCount: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodRecipeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FoodListScreen(modifier = Modifier.padding(innerPadding), viewModel = viewModel)
                }
            }
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (++backPressCount < 2 && viewModel.state.value.selectedRecipe != null) {
                    viewModel.onAction(FoodListAction.BackToMainScreen)
                    backPressCount = 0
                } else {
                    finishAffinity()
                }
            }
        })
    }
}