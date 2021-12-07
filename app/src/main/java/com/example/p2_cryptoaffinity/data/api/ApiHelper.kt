package com.example.p2_cryptoaffinity.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getTickers() = apiService.getTickers("USD")
    suspend fun getTicker(id : String) = apiService.getTicker(id, "USD")
}