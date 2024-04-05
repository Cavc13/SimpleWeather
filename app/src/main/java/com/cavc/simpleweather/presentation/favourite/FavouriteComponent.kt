package com.cavc.simpleweather.presentation.favourite

import com.cavc.simpleweather.domain.entity.City
import kotlinx.coroutines.flow.StateFlow

interface FavouriteComponent {

    val model: StateFlow<FavouriteStore.State>

    fun onclickSearch()

    fun onclickAddFavourite()

    fun onCityItemClick(city: City)
}