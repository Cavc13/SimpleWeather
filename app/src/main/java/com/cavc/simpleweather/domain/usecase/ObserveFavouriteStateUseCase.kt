package com.cavc.simpleweather.domain.usecase

import com.cavc.simpleweather.domain.entity.City
import com.cavc.simpleweather.domain.repository.FavouriteRepository
import javax.inject.Inject

class ObserveFavouriteStateUseCase @Inject constructor(
    private val repository: FavouriteRepository
) {
    operator fun invoke(cityId: Int) = repository.observeIsFavourite(cityId)
}