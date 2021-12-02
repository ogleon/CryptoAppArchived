package com.example.p2_cryptoaffinity.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Status {
    @SerializedName("timestamp")
    @Expose
    var timestamp: String? = null

    @SerializedName("error_code")
    @Expose
    var errorCode: Int? = null

    @SerializedName("error_message")
    @Expose
    var errorMessage: Any? = null

    @SerializedName("elapsed")
    @Expose
    var elapsed: Int? = null

    @SerializedName("credit_count")
    @Expose
    var creditCount: Int? = null

    companion object {
        private const val serialVersionUID = -8863009672190576366L
    }
}