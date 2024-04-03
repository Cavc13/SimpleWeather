package com.cavc.simpleweather.domain.repository

import com.cavc.simpleweather.domain.entity.City
import com.cavc.simpleweather.domain.entity.Forecast
import com.cavc.simpleweather.domain.entity.Weather

interface WeatherRepository {

    suspend fun getWeather(cityId: Int) : Weather

    suspend fun getForecast(cityId: Int): Forecast
}