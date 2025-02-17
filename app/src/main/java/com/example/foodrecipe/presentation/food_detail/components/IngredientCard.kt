package com.example.foodrecipe.presentation.food_detail.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.R

@Composable
fun IngredientCart(ingredients: List<String?>, measurer: List<String?>) {
    val isShow = remember { mutableStateOf(false) }
    AnimatedVisibility(
        visible = !isShow.value,
        modifier = Modifier
            .clickable {
                isShow.value = !isShow.value
            }
    ) {
        Row (
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.right),
                contentDescription = stringResource(R.string.right_arrow)
            )
            Text(
                text = "Ingredients",
                fontSize = 18.sp
            )
        }
    }
    ingredients
        .filter { it!!.isNotEmpty() }
        .mapIndexed { index, ingredient ->
            AnimatedVisibility(visible = isShow.value) {
                Row (
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier
                        .clickable {
                            isShow.value = !isShow.value
                        }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.plus),
                        contentDescription = stringResource(R.string.plus)
                    )
                    Text(
                        text = "${ingredient}: ${measurer[index]}",
                        fontSize = 18.sp
                    )
                }
            }
        }
}