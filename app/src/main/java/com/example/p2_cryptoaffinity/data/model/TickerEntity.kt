package com.example.p2_cryptoaffinity.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TickerEntity(
    val id: String,
    val name: String,
    val symbol: String,
    val rank: Int = -1,
    @Json(name = "circulating_supply") val circulatingSupply: Long = 0,
    @Json(name = "total_supply") val totalSupply: Long = 0,
    @Json(name = "max_supply") val maxSupply: Long = 0,
    @Json(name = "beta_value") val betaValue: Double = 0.0,
    @Json(name = "last_updated") val lastUpdated: String? = "",
    var quotes: Map<String, QuoteEntity>? = emptyMap(),
    var tags: List<String>? = emptyList()
)

fun TickerEntity.toCoin(): Coin {
    return Coin(
        id = id,
        name = name,
        symbol = symbol,
        lastUpdated = lastUpdated.toString(),
        percentChange1h = quotes?.get("USD")?.percentChange1h.toString(),
        percentchange24h = quotes?.get("USD")?.percentChange24h.toString(),
        percentChange7d = quotes?.get("USD")?.percentChange7d.toString(),
        marketCap = quotes?.get("USD")?.marketCap.toString(),
        price = quotes?.get("USD")?.price.toString(),
        maxSupply = maxSupply.toString(),
        totalSupply = totalSupply.toString(),
        circulatingSupply = circulatingSupply.toString(),
        rank = rank.toString()
    )
}