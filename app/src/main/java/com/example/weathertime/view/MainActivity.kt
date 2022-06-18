package com.example.weathertime.view.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.weathertime.databinding.ActivityMainBinding
import com.example.weathertime.view.network.WeatherResponse
import com.example.weathertime.view.viewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.weather.observe(this){
            updateUI(it)
        }
        binding.bvGet.setOnClickListener {
            viewModel.getWeather(binding.editTextSearchCity.text.toString())
        }
    }

    private fun updateUI(newWeatherData: WeatherResponse) {

        binding.tvWeatherUpdate.text = newWeatherData.current.condition.text
        binding.tvResultHumidity.text = newWeatherData.current.humidity.toString() + "%"
        binding.tvTempC.text = newWeatherData.current.temp_c.toString() + "°C"

        try {
            Glide.with(this).load("https:"+newWeatherData.current.condition.icon).into(binding.ivWeatherIcon)
            Log.d("Icon link", "https:"+newWeatherData.current.condition.icon)
        }catch (e: Exception){
        }

    }
}