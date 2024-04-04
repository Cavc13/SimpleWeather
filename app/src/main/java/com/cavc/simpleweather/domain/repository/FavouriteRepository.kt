package com.cavc.simpleweather.domain.repository

import com.cavc.simpleweather.domain.entity.City
import kotlinx.coroutines.flow.Flow

interface FavouriteRepository {
    val favouriteCities: Flow<List<City>>

    fun observeIsFavourite(cityId: Int): Flow<Boolean>

    suspend fun addToFavourite(city: City)

    suspend fun removeFromFavourite(cityId: Int)
}