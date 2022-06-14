package com.example.weathertime.view.di

import com.example.weathertime.view.viewModel.MainViewModel
import com.example.weathertime.view.network.Repository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { MainViewModel (repository = get()) }

}

val repositoriesModule = module {

    factory { Repository() }

}