package com.cavc.simpleweather.domain.entity

data class Forecast(
    val currentWeather: Weather,
    val upcoming: List<Weather>
)
