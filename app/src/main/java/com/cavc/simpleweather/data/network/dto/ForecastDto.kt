package com.cavc.simpleweather.data.network.dto

import com.cavc.simpleweather.domain.entity.Forecast
import com.google.gson.annotations.SerializedName

data class ForecastDto(
    @SerializedName("forecastday") val forecastDay: List<DayDto>
)
