package com.example.p2_cryptoaffinity.data.repository

import com.example.p2_cryptoaffinity.data.remote.CoinPaprikaApi
import com.example.p2_cryptoaffinity.data.remote.dto.CoinDetailDto
import com.example.p2_cryptoaffinity.data.remote.dto.CoinDto
import com.example.p2_cryptoaffinity.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}