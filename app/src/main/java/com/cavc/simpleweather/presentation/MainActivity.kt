package com.cavc.simpleweather.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.cavc.simpleweather.WeatherApp
import com.cavc.simpleweather.data.network.api.ApiFactory
import com.cavc.simpleweather.presentation.root.DefaultRootComponent
import com.cavc.simpleweather.presentation.root.RootContent
import com.cavc.simpleweather.presentation.ui.theme.SimpleWeatherTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var rootComponentFactory: DefaultRootComponent.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as WeatherApp).applicationComponent.inject(this)

        super.onCreate(savedInstanceState)

        val root = rootComponentFactory.create(defaultComponentContext())
        setContent { 
            RootContent(component = root)
        }
    }
}