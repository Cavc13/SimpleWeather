package com.cavc.simpleweather.domain.repository

import com.cavc.simpleweather.domain.entity.City

interface SearchRepository {

    suspend fun search(query: String): List<City>
}