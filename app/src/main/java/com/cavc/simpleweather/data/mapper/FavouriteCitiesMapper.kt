package com.cavc.simpleweather.data.mapper

import com.cavc.simpleweather.data.local.model.CityDbModel
import com.cavc.simpleweather.domain.entity.City

fun City.toDbModel(): CityDbModel = CityDbModel(id, name, country)

fun CityDbModel.toEntity(): City = City(id, name, country)

fun List<CityDbModel>.toEntities(): List<City> = map { it.toEntity() }