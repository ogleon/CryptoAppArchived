package com.example.p2_cryptoaffinity.data.repository

import com.example.p2_cryptoaffinity.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()
}