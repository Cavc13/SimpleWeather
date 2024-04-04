package com.cavc.simpleweather.data.repository

import com.cavc.simpleweather.data.mapper.toEntity
import com.cavc.simpleweather.data.network.api.ApiService
import com.cavc.simpleweather.domain.entity.Forecast
import com.cavc.simpleweather.domain.entity.Weather
import com.cavc.simpleweather.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): WeatherRepository {
    override suspend fun getWeather(cityId: Int): Weather {
        return apiService.loadCurrentWeather("$PREFIX_CITY_ID$cityId").toEntity()
    }

    override suspend fun getForecast(cityId: Int): Forecast {
        return apiService.loadForecast("$PREFIX_CITY_ID$cityId").toEntity()
    }

    companion object{

        private  const val PREFIX_CITY_ID = "id:"
    }
}