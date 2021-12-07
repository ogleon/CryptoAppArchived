package com.example.p2_cryptoaffinity.data.api

import com.example.p2_cryptoaffinity.data.model.SearchEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET("search/?c=currencies,icos,people,tags")
    suspend fun getSearches(@Query("q") query: String): SearchEntity
}