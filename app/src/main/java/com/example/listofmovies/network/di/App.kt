package com.example.listofmovies.network.di

import android.app.Application
import com.example.myapplicationone.di.AppModule


class App : Application() {
    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}