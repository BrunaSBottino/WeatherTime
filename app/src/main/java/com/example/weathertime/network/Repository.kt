package com.example.weathertime.view.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository {

    suspend fun getWeather(search: String) = withContext(Dispatchers.IO) {
        RetrofitInstance.api.getWeather(search = search)
    }

}