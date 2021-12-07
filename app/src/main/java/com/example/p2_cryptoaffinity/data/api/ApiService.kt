package com.example.p2_cryptoaffinity.data.api

import com.example.p2_cryptoaffinity.data.model.CoinResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("tickers/{id}/")
    suspend fun getTicker(
        @Path("id") id: String,
        @Query("quotes") quotes: String
    ): CoinResponse

    @GET("tickers")
    suspend fun getTickers(
        @Query("quotes") quotes: String,
        @Query("limit") limit: Int? = null
    ): List<CoinResponse>
}