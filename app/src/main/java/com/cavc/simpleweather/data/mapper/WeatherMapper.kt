package com.cavc.simpleweather.data.mapper

import com.cavc.simpleweather.data.network.dto.WeatherCurrentDto
import com.cavc.simpleweather.data.network.dto.WeatherDto
import com.cavc.simpleweather.data.network.dto.WeatherForecastDto
import com.cavc.simpleweather.domain.entity.Forecast
import com.cavc.simpleweather.domain.entity.Weather
import java.util.Calendar
import java.util.Date


fun WeatherCurrentDto.toEntity(): Weather = current.toEntity()
fun WeatherDto.toEntity(): Weather = Weather(
    tempC = tempC,
    conditionalText = conditionDto.text,
    conditionalUrl = conditionDto.iconUrl.correctImageUrl(),
    date = date.toCalendar()
)

fun WeatherForecastDto.toEntity() = Forecast(
    currentWeather = current.toEntity(),
    upcoming = forecastDto.forecastDay.drop(1).map {dayDto ->
         with(dayDto.dayWeatherDto) {
             Weather(
                 tempC = this.tempC,
                 conditionalText = this.conditionDto.text,
                 conditionalUrl = this.conditionDto.iconUrl.correctImageUrl(),
                 date = dayDto.date.toCalendar()
             )
         }
    }
)

private fun Long.toCalendar() = Calendar.getInstance().apply {
    time = Date(this@toCalendar * 1_000)
}

private fun String.correctImageUrl() = "https:$this".replace(
    oldValue = "64x64",
    newValue = "128x128"
)