package com.victorteka.cryptocurrencyapp.ui.coinlist

import com.victorteka.domain.models.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
