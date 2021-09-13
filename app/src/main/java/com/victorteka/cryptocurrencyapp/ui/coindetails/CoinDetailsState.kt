package com.victorteka.cryptocurrencyapp.ui.coindetails

import com.victorteka.domain.models.CoinDetails

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coin: CoinDetails? = null,
    val error: String = ""
)
