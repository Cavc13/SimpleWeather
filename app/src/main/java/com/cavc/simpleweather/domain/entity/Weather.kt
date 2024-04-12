package com.cavc.simpleweather.domain.entity

data class Weather(
    val tempC: Float,
    val conditionalText: String,
    val conditionalUrl: String,
    val date: String
)
