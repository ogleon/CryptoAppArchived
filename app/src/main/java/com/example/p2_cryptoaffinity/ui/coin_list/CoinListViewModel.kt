package com.example.p2_cryptoaffinity.ui.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.p2_cryptoaffinity.data.repository.MainRepository
import com.example.p2_cryptoaffinity.utils.Resource
import kotlinx.coroutines.Dispatchers

class CoinListViewModel(private val mainRepository: MainRepository) : ViewModel() {

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}