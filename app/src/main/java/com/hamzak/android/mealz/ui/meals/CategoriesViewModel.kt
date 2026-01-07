package com.hamzak.android.mealz.ui.meals

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamzak.android.model.MealRepository
import com.hamzak.android.model.response.MealsResponse
import kotlinx.coroutines.launch

class CategoriesViewModel(
    private val repository: MealRepository = MealRepository()
) : ViewModel() {

    val mealsState = mutableStateOf<List<MealsResponse>>(emptyList())

    fun getMeals() {
        viewModelScope.launch {
            try {
                val meals = repository.getMeals()
                mealsState.value = meals.categories
            } catch (e: Exception) {
                // Handle the error
                e.printStackTrace()
            }
        }
    }
}