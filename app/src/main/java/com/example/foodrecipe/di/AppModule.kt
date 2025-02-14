package com.example.foodrecipe.di

import com.example.foodrecipe.core.data.RemoteDatasource
import com.example.foodrecipe.core.networking.HttpClientFactory
import com.example.foodrecipe.domain.RecipeDatasource
import com.example.foodrecipe.presentation.food_list.FoodListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::RemoteDatasource).bind<RecipeDatasource>()

    viewModelOf(::FoodListViewModel)
}