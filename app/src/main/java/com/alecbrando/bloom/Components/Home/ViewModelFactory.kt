package com.alecbrando.bloom.Components.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alecbrando.bloom.model.RepositoryImpl

class ViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val repository = RepositoryImpl()
        return HomeViewModel(repository) as T
    }
}