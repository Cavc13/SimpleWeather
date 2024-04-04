package com.cavc.simpleweather.di

import android.content.Context
import com.cavc.simpleweather.data.local.db.FavouriteCitiesDao
import com.cavc.simpleweather.data.local.db.FavouriteDatabase
import com.cavc.simpleweather.data.network.api.ApiFactory
import com.cavc.simpleweather.data.network.api.ApiService
import com.cavc.simpleweather.data.repository.FavouriteRepositoryImpl
import com.cavc.simpleweather.data.repository.SearchRepositoryImpl
import com.cavc.simpleweather.data.repository.WeatherRepositoryImpl
import com.cavc.simpleweather.domain.repository.FavouriteRepository
import com.cavc.simpleweather.domain.repository.SearchRepository
import com.cavc.simpleweather.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @[ApplicationScope Binds]
    fun bindFavouriteRepository(impl: FavouriteRepositoryImpl): FavouriteRepository

    @[ApplicationScope Binds]
    fun bindWeatherRepository(impls: WeatherRepositoryImpl): WeatherRepository

    @[ApplicationScope Binds]
    fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository

    companion object{

        @[ApplicationScope Provides]
        fun provideApiService(): ApiService = ApiFactory.apiService

        @[ApplicationScope Provides]
        fun provideFavouriteDatabase(context: Context): FavouriteDatabase {
            return FavouriteDatabase.getInstance(context)
        }

        @[ApplicationScope Provides]
        fun provideFavouriteCitiesDao(database: FavouriteDatabase): FavouriteCitiesDao {
            return database.favouriteCitiesDao()
        }
    }
}