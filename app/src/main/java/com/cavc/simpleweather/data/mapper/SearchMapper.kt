package com.cavc.simpleweather.data.mapper

import com.cavc.simpleweather.data.network.dto.CityDto
import com.cavc.simpleweather.domain.entity.City

fun CityDto.toEntity(): City = City(id, name, country)

fun List<CityDto>.toEntities(): List<City> = map { it.toEntity()}