package com.alecbrando.bloom.model

import com.alecbrando.bloom.PlantTheme
import com.alecbrando.bloom.defaultPlantThemes
import com.alecbrando.bloom.homeGardenItems

class RepositoryImpl : Repository {
    override suspend fun getDefaultThemes(): List<PlantTheme> {
        return defaultPlantThemes
    }

    override suspend fun getHomeGardenItems(): List<PlantTheme> {
        return homeGardenItems
    }
}