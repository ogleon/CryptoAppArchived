package com.example.p2_cryptoaffinity.presentation.coin_detail

import com.example.p2_cryptoaffinity.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)