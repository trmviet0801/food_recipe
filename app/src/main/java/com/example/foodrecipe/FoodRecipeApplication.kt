package com.example.foodrecipe

import android.app.Application
import com.example.foodrecipe.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FoodRecipeApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FoodRecipeApplication)
            androidLogger()
            modules(appModule)
        }
    }
}