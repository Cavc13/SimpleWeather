package com.cavc.simpleweather.data.repository

import com.cavc.simpleweather.data.local.db.FavouriteCitiesDao
import com.cavc.simpleweather.data.mapper.toDbModel
import com.cavc.simpleweather.data.mapper.toEntities
import com.cavc.simpleweather.domain.entity.City
import com.cavc.simpleweather.domain.repository.FavouriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavouriteRepositoryImpl @Inject constructor(
    private val favouriteCitiesDao: FavouriteCitiesDao
): FavouriteRepository {
    override val favouriteCities: Flow<List<City>>
        get() = favouriteCitiesDao.getFavouriteCities().map { it.toEntities() }

    override fun observeIsFavourite(cityId: Int): Flow<Boolean> = favouriteCitiesDao
        .observeIsFavourite(cityId)


    override suspend fun addToFavourite(city: City) {
        favouriteCitiesDao.addToFavourite(city.toDbModel())
    }

    override suspend fun removeFromFavourite(cityId: Int) {
        favouriteCitiesDao.removeFromFavourite(cityId)
    }
}