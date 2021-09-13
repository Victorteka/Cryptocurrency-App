package com.victorteka.data.network.repository

import com.victorteka.data.network.CoinPaprikaApi
import com.victorteka.data.network.mappers.toDomain
import com.victorteka.domain.models.Coin
import com.victorteka.domain.models.CoinDetails
import com.victorteka.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<Coin> {
        return api.getCoins().map { it.toDomain() }
    }

    override suspend fun getCoinById(coinId: String): CoinDetails {
        return api.getCoinById(coinId).toDomain()
    }

}