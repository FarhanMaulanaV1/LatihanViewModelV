package com.example.latihanviewmodelv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.launch

class ThemeViewModel(private val pref: SettingPreferences) : ViewModel() {
    fun getTheme(): LiveData<Boolean> {
        return pref.getTheme().asLiveData()
    }

    fun saveTheme(isDarkModeActive: Boolean){
        viewModelScope.launch{
            pref.saveTheme(isDarkModeActive)
        }
    }

}