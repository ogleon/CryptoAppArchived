package com.example.p2_cryptoaffinity.interfaces

import com.example.p2_cryptoaffinity.retrofit.CryptoList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface APIInterface {
    @Headers("X-CMC_PRO_API_KEY: ac3b2e55-2288-46be-8544-cf2ee5dded41")
    @GET("/v1/cryptocurrency/listings/latest?")
    fun doGetUserList(@Query("limit") page: String?): Call<CryptoList?>?
}