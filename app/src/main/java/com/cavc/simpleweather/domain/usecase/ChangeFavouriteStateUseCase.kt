package com.cavc.simpleweather.domain.usecase

import com.cavc.simpleweather.domain.entity.City
import com.cavc.simpleweather.domain.repository.FavouriteRepository
import javax.inject.Inject

class ChangeFavouriteStateUseCase @Inject constructor(
    private val repository: FavouriteRepository
) {
    suspend fun addToFavourite(city: City) = repository.addToFavourite(city)

    suspend fun removeFromFavourite(cityId: Int) = repository.removeFromFavourite(cityId)
}