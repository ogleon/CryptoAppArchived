package com.example.p2_cryptoaffinity.retrofit

import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

class Quote {
    @SerializedName("USD")
    @Expose
    var uSD: USD? = null

    companion object {
        private const val serialVersionUID = -5780538494495942860L
    }
}