package com.example.p2_cryptoaffinity.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.p2_cryptoaffinity.data.api.ApiHelper
import com.example.p2_cryptoaffinity.data.repository.MainRepository
import com.example.p2_cryptoaffinity.ui.main.viewmodel.TickerViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TickerViewModel::class.java)) {
            return TickerViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")    }

}