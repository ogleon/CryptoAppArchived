package com.example.p2_cryptoaffinity

import com.example.p2_cryptoaffinity.models.Coin
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/data/all/coinlist")
    fun getCoins(): Call<List<Coin>>

}
