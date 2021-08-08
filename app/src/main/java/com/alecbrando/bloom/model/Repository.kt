package com.alecbrando.bloom.model

import com.alecbrando.bloom.PlantTheme

interface Repository {
    suspend fun getDefaultThemes() : List<PlantTheme>

    suspend fun getHomeGardenItems() : List<PlantTheme>
}