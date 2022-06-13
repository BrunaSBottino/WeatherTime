package com.example.weathertime.view.network

import com.example.weathertime.view.model.Current
import com.example.weathertime.view.model.LocationX

data class WeatherResponse(
    val current: Current,
    val location: LocationX
)