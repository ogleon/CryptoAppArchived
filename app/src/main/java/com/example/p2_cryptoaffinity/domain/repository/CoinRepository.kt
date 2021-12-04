package com.example.p2_cryptoaffinity.domain.repository

import com.example.p2_cryptoaffinity.data.remote.dto.CoinDetailDto
import com.example.p2_cryptoaffinity.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}