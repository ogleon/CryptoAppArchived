package com.example.p2_cryptoaffinity.presentation.coin_list

import com.example.p2_cryptoaffinity.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)