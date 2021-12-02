package com.example.p2_cryptoaffinity.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CryptoList {

    @SerializedName("status")
    @Expose
    var status: Status? = null

    @SerializedName("coins")
    @Expose
    var coins: List<Coin>? = null

    companion object {
        private const val serialVersionUID = -4369048252305703014L
    }
}