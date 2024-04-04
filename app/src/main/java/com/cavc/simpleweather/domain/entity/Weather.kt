package com.cavc.simpleweather.domain.entity

import java.util.Calendar

data class Weather(
    val tempC: Float,
    val conditionalText: String,
    val conditionalUrl: String,
    val date: Calendar
)
