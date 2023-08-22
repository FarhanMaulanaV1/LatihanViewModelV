package com.example.latihanviewmodelv

import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.os.Bundle
import android.widget.CompoundButton
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModelProvider
import com.example.latihanviewmodelv.databinding.ActivityThemeBinding
import androidx.appcompat.app.AppCompatDelegate

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class ThemeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThemeBinding
    private lateinit var themeViewModel: ThemeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThemeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pref = SettingPreferences.getInstance(dataStore)
        themeViewModel =
            ViewModelProvider(this, ViewModelFactory(pref))[ThemeViewModel::class.java]
        
        themeViewModel.getTheme().observe(this) { isDarkModeActive ->
            applyTheme(isDarkModeActive)
            binding.switchTheme.isChecked = isDarkModeActive
        }

        binding.switchTheme.setOnCheckedChangeListener { _: CompoundButton, isChecked: Boolean ->
            themeViewModel.saveTheme(isChecked)
        }
    }

    private fun applyTheme(isDarkModeActive: Boolean) {
        if (isDarkModeActive) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}