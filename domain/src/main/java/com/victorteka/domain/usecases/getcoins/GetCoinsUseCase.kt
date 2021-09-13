package com.victorteka.domain.usecases.getcoins

import com.victorteka.domain.models.Coin
import com.victorteka.domain.repository.CoinRepository
import com.victorteka.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class GetCoinsUseCase(private val repository: CoinRepository) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins()
            emit(Resource.Success(coins))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check internet connection!"))
        } catch (e: Exception) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An error occurred! Try again"))
        }
    }
}