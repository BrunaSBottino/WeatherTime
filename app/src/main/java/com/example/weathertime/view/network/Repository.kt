package com.example.weathertime.view.network

import com.example.weathertime.view.network.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class Repository {

    suspend fun getWeather(search: String) = withContext(Dispatchers.IO) {
        RetrofitInstance.api.getWeather(search = search)
    }

}