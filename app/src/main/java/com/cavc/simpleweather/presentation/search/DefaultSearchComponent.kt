package com.cavc.simpleweather.presentation.search

import com.arkivanov.decompose.ComponentContext

class DefaultSearchComponent(
    componentContext: ComponentContext
) : SearchComponent, ComponentContext by componentContext