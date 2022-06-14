package com.example.weathertime.view.di

import android.app.Application
import org.koin.core.context.startKoin

class WeatherApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(viewModelsModule, repositoriesModule)
        }
    }
}