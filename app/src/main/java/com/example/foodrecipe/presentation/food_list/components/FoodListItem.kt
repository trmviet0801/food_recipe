package com.example.foodrecipe.presentation.food_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.foodrecipe.domain.FoodRecipe
import com.example.foodrecipe.ui.theme.FoodRecipeTheme
import com.example.foodrecipe.ui.theme.Purple40

@Composable
fun FoodListItem(
    recipe: FoodRecipe,
    modifier: Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .width(160.dp)
            .shadow(
                elevation = 16.dp,
                ambientColor = Color.Green,
                spotColor = Purple40
            )
            .clickable { onClick() }
    ) {
        AsyncImage(
            model = recipe.strMealThumb,
            contentDescription = recipe.strMeal,
            modifier = Modifier.fillMaxWidth(),
        )
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = recipe.strMeal,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 10.dp)
            )
            Text(
                text = recipe.strArea,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

val previewRecipe = FoodRecipe(
    idMeal = "52771",
    strMeal = "Spicy Arrabiata Penne",
    strCategory = "Vegetarian",
    strInstructions = "Bring a large pot of water to a boil. Add kosher salt to the boiling water, then add the pasta. Cook according to the package instructions, about 9 minutes.\\r\\nIn a large skillet over medium-high heat, add the olive oil and heat until the oil starts to shimmer. Add the garlic and cook, stirring, until fragrant, 1 to 2 minutes. Add the chopped tomatoes, red chile flakes, Italian seasoning and salt and pepper to taste. Bring to a boil and cook for 5 minutes. Remove from the heat and add the chopped basil.\\r\\nDrain the pasta and add it to the sauce. Garnish with Parmigiano-Reggiano flakes and more basil and serve warm.",
    strMealThumb = "https://www.themealdb.com/images/media/meals/ustsqw1468250014.jpg",
    strYoutube = "https://www.youtube.com/watch?v=1IszT_guI08",
    strIngredients = listOf(
        "penne rigate",
        "olive oil",
        "garlic",
        "chopped tomatoes",
        "red chilli flakes",
        "italian seasoning",
        "basil",
        "Parmigiano-Reggiano"
    ),
    strMeasures = listOf(
        "1 pound",
        "1/4 cup",
        "3 cloves",
        "1 tin ",
        "1/2 teaspoon",
        "1/2 teaspoon",
        "6 leaves",
        "sprinkling"
    ),
    strArea = "Italian"
)

@PreviewLightDark
@Composable
private fun FoodListItemPreview() {
    FoodRecipeTheme {
        FoodListItem(previewRecipe, Modifier)
    }
}