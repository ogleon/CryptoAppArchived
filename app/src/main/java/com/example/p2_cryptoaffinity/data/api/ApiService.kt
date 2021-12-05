package com.example.p2_cryptoaffinity.data.api

import com.example.p2_cryptoaffinity.utils.Constants
import com.example.p2_cryptoaffinity.data.model.TickerEntity
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("tickers/{id}/")
    suspend fun getTicker(
        @Path("id") id: String,
        @Query("quotes") quotes: String
    ): TickerEntity

    @GET("tickers")
    suspend fun getTickers(
        @Query("quotes") quotes: String,
        @Query("limit") limit: Int? = null
    ): List<TickerEntity>


    companion object {

        suspend fun createApiConnection(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().build())
                .build()
            return retrofit.create()
        }


    }
}