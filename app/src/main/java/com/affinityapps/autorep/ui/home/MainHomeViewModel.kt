package com.affinityapps.autorep.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainHomeViewModel: ViewModel() {

    private val position = MutableLiveData<Int>()

    fun dataTransfer(input: Int){
        position.value = input
    }
}