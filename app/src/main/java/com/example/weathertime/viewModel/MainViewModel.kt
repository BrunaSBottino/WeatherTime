package com.example.weathertime.view.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathertime.view.network.Repository
import com.example.weathertime.view.network.WeatherResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    // Variavel observavel weather (esta sendo observada na main activity)
    val weather = MutableLiveData<WeatherResponse>()

    fun getWeather(search: String) {
        viewModelScope.launch {
            try {
                val response: Response<WeatherResponse> = repository.getWeather(search)

                // Se a resposta for um sucesso e o corpo NAO ESTIVER VAZIO
                if (response.isSuccessful && response.body()!=null) {
                    // Atualize a variavel weather que esta sendo observada
                    weather.value = response.body()
                }
            } catch (e: Exception) {
                Log.e("Erro de conexao", "${e.message}")
            }
        }
    }

}