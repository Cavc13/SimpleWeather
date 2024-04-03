package com.cavc.simpleweather.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.cavc.simpleweather.data.network.api.ApiFactory
import com.cavc.simpleweather.presentation.ui.theme.SimpleWeatherTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val apiService = ApiFactory.apiService

        CoroutineScope(Dispatchers.Main).launch {
            val currentWeather = apiService.loadCurrentWeather("Liverpool")
            val forecast = apiService.loadForecast("Liverpool")
            val cities = apiService.searchCity("Liverpool")

            Log.d(
                "MainActivity",
                "Current Weather: $currentWeather\nForecast Weather: $forecast\nCities: $cities"
            )
        }

        setContent {
            SimpleWeatherTheme {

            }
        }
    }
}