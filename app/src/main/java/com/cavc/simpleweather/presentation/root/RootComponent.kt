package com.cavc.simpleweather.presentation.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.cavc.simpleweather.presentation.details.DetailsComponent
import com.cavc.simpleweather.presentation.favourite.FavouriteComponent
import com.cavc.simpleweather.presentation.search.SearchComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    sealed interface Child {

        data class Favourite(val component: FavouriteComponent) : Child

        data class Search(val component: SearchComponent) : Child

        data class Details(val component: DetailsComponent) : Child
    }
}