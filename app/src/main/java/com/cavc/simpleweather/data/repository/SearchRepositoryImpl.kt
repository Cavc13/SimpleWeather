package com.cavc.simpleweather.data.repository

import com.cavc.simpleweather.data.mapper.toEntities
import com.cavc.simpleweather.data.network.api.ApiService
import com.cavc.simpleweather.domain.entity.City
import com.cavc.simpleweather.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): SearchRepository {
    override suspend fun search(query: String): List<City> {
        return apiService.searchCity(query).toEntities()
    }
}