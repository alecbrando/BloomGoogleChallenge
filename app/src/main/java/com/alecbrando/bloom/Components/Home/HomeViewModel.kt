package com.alecbrando.bloom.Components.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alecbrando.bloom.PlantTheme
import com.alecbrando.bloom.R
import com.alecbrando.bloom.model.RepositoryImpl
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repositoryImpl: RepositoryImpl
) : ViewModel() {

    private val _plantThemeItems = MutableLiveData<List<PlantTheme>>()
    val plantThemeItems: LiveData<List<PlantTheme>> get() = _plantThemeItems

    private val _defaultGardenItems = MutableLiveData<List<PlantTheme>>()
    val defaultGardenItems: LiveData<List<PlantTheme>> get() = _defaultGardenItems

    var loadingGarden = MutableLiveData<Boolean>(true)
    var loadingPlantThemes = MutableLiveData<Boolean>(true)

    init {
        getPlantThemesData()
        getDefaultGardenItems()
    }

    private fun getPlantThemesData() {
        viewModelScope.launch {
            val res = repositoryImpl.getDefaultThemes()
            _plantThemeItems.value = res
            loadingGarden.value = false
        }
    }

    private fun getDefaultGardenItems() {
        viewModelScope.launch {
            val res = repositoryImpl.getHomeGardenItems()
            _defaultGardenItems.value = res
            loadingPlantThemes.value = false
        }
    }
}