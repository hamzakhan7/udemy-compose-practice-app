package com.hamzak.android.mealz.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hamzak.android.mealz.ui.theme.MealzTheme
import com.hamzak.android.model.response.MealsResponse

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MealzTheme {
                CategoriesScreen()
            }
        }
    }
}

@Composable
fun CategoriesScreen(modifier: Modifier = Modifier) {
    val viewModel : CategoriesViewModel = viewModel()
    LaunchedEffect(Unit){
        viewModel.getMeals()

    }
    val meals = viewModel.mealsState.value

    LazyColumn {
        items(meals){
            Text(text = it.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CategoriesScreen()
}
