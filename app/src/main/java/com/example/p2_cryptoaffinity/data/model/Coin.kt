package com.example.p2_cryptoaffinity.data.model

data class Coin(
    var id: String,
    var name: String,
    var symbol: String,
    var rank: String,
    var price: String,
    var percentChange1h: String,
    var percentchange24h: String,
    var percentChange7d: String,
    var lastUpdated: String,
    var marketCap: String,
    var maxSupply: String,
    var circulatingSupply: String,
    var totalSupply: String,

)