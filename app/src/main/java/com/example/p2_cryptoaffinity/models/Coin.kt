package com.example.p2_cryptoaffinity.models

import com.google.gson.annotations.SerializedName

data class Coin(

    @SerializedName("CoinName")
    val CoinName: String,
    @SerializedName("imageUrl")
    val ImageUrl: String,
    @SerializedName("Description")
    val Description: String,

    val price : Price
)