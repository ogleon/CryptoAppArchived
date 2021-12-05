package com.example.p2_cryptoaffinity.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getUsers() = apiService.getTickers("USD")
}