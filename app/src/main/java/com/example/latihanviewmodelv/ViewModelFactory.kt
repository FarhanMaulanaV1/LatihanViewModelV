package com.example.latihanviewmodelv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val pref: SettingPreferences) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom((ThemeViewModel::class.java))) {
            return ThemeViewModel(pref) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel Class: " + modelClass.name)
    }
}