package com.example.p2_cryptoaffinity.model

data class Coin(
    var id: String,
    var symbol: String,
    var name: String,
    var price: String,
    var percent_change_1h: String,
    var percent_change_24h: String,
    var percent_change_7d: String
)