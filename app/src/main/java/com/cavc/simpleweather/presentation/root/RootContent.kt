package com.cavc.simpleweather.presentation.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.cavc.simpleweather.presentation.details.DetailsContent
import com.cavc.simpleweather.presentation.favourite.FavouriteContent
import com.cavc.simpleweather.presentation.search.SearchContent
import com.cavc.simpleweather.presentation.ui.theme.SimpleWeatherTheme

@Composable
fun RootContent(component: RootComponent){

    SimpleWeatherTheme {
        Children(
            stack = component.stack
        ) {
            when(val instance = it.instance) {
                is RootComponent.Child.Details -> {
                    DetailsContent(component = instance.component)
                }
                is RootComponent.Child.Favourite -> {
                    FavouriteContent(component = instance.component)
                }
                is RootComponent.Child.Search -> {
                    SearchContent(component = instance.component)
                }
            }
        }
    }
}