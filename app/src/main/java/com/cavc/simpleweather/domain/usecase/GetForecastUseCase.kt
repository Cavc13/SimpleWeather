package com.cavc.simpleweather.domain.usecase

import com.cavc.simpleweather.domain.repository.WeatherRepository
import javax.inject.Inject

class GetForecastUseCase @Inject constructor(
    private val repository: WeatherRepository
) {

    suspend operator fun invoke(cityId: Int) = repository.getForecast(cityId)
}