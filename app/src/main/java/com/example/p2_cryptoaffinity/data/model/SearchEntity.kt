package com.example.p2_cryptoaffinity.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchEntity(
    val currencies: List<TickerEntity>,
)