package com.cavc.simpleweather.domain.usecase

import com.cavc.simpleweather.domain.repository.SearchRepository
import javax.inject.Inject

class SearchCityUseCase @Inject constructor(
    private val repository: SearchRepository
) {
    suspend operator fun invoke(query: String) = repository.search(query)
}