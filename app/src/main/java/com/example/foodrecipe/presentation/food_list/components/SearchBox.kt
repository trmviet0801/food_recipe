package com.example.foodrecipe.presentation.food_list.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipe.R
import com.example.foodrecipe.ui.theme.FoodRecipeTheme

@Composable
fun SearchBox(
    onChange: (String) -> Unit
) {
    val text = remember {
        mutableStateOf("")
    }
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextField(
            value = text.value,
            onValueChange = { text.value = it },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.enter_some_foods_or_ingredients),
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.primary,
                    fontFamily = FontFamily.Monospace
                )
            },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(8.dp)
                )
                .fillMaxWidth(),
            textStyle = LocalTextStyle.current.copy(
                fontFamily = FontFamily.Monospace
            ),
            trailingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.search),
                    contentDescription = stringResource(id = R.string.search)
                )
            }
        )
    }
}

@PreviewLightDark
@Composable
private fun SearchBoxPreview() {
    FoodRecipeTheme {
        SearchBox() {

        }
    }
}