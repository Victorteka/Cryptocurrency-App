package com.victorteka.domain.usecases.getcoindetails

import com.victorteka.domain.models.CoinDetails
import com.victorteka.domain.repository.CoinRepository
import com.victorteka.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class GetCoinUseCase(private val repository: CoinRepository) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading<CoinDetails>())
            val coin = repository.getCoinById(coinId)
            emit(Resource.Success(coin))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetails>("Couldn't reach server. Check internet connection!"))
        } catch (e: Exception) {
            emit(Resource.Error<CoinDetails>(e.localizedMessage ?: "An error occurred! Try again"))
        }
    }
}