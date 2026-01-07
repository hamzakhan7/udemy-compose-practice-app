package com.hamzak.android.mealz.ui.meals

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.hamzak.android.model.response.MealsResponse

@Composable
fun CategoriesScreen(modifier: Modifier = Modifier) {
    val viewModel : CategoriesViewModel = viewModel()
    LaunchedEffect(Unit){
        viewModel.getMeals()
    }
    val meals = viewModel.mealsState.value

    LazyColumn (
        contentPadding = PaddingValues(16.dp)
    ) {
        items(meals){ meal ->
            MealCategory(meal)
        }
    }
}

@Composable
fun MealCategory(meal: MealsResponse){
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 16.dp
        )
    ) {
        Row {
            AsyncImage(
                model = meal.imageUrl,
                contentDescription = null
            )

            Column (
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            ){
                Text(
                    text = meal.name,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CategoriesScreen()
}