package com.cavc.simpleweather

import android.app.Application
import com.cavc.simpleweather.di.ApplicationComponent
import com.cavc.simpleweather.di.DaggerApplicationComponent

class WeatherApp : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}