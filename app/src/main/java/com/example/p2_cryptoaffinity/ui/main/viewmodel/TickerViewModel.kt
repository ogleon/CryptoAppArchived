package com.example.p2_cryptoaffinity.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.p2_cryptoaffinity.data.model.CoinResponse
import com.example.p2_cryptoaffinity.data.repository.MainRepository
import com.example.p2_cryptoaffinity.utils.Resource
import kotlinx.coroutines.Dispatchers

class TickerViewModel(private val mainRepository: MainRepository) : ViewModel() {

    lateinit var selectedId : MutableLiveData<String>

    fun getCoins() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getTickers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun getCoin(id: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getTicker(id)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }


    fun select(id: String) {
        selectedId.value = id
    }


}