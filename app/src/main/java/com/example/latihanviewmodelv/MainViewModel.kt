package com.example.latihanviewmodelv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData

class MainViewModel : ViewModel() {
    var number = 0

    private val _currentNumber = MutableLiveData<Int>()
    fun currentNumber(): LiveData<Int> = _currentNumber

    private val _currentType = MutableLiveData<String>()
    fun currentType(): LiveData<String> = _currentType

    fun increment() {
        number += 1

        _currentNumber.value = number

        if (number % 2 == 0) {
            _currentType.value = "Genap"
        } else {
            _currentType.value = "Ganjil"
        }
    }
}