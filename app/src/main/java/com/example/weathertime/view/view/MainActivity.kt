package com.example.weathertime.view.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        binding.tvDay.text = newWeatherData.current.condition.text
    }
}