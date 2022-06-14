package com.example.weathertime.view.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/current.json")
    suspend fun getWeather(
        @Query("key")key: String = Credentials.key,
        @Query("q")search: String
    ) : Response<WeatherResponse>

}