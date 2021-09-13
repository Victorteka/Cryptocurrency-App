package com.victorteka.domain.repository

import com.victorteka.domain.models.Coin
import com.victorteka.domain.models.CoinDetails

interface CoinRepository {

    suspend fun getCoins(): List<Coin>

    suspend fun getCoinById(coinId: String): CoinDetails

}