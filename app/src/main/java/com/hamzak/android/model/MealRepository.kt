package com.hamzak.android.model

import com.hamzak.android.model.response.MealsCategoriesResponse

class MealRepository(
    private val webService: WebService = WebService()
) {
    suspend fun getMeals(): MealsCategoriesResponse {
        return webService.getMeals()
    }
}