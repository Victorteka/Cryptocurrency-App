package com.victorteka.data.network.mappers

import com.victorteka.data.network.dto.CoinDetailsDto
import com.victorteka.data.network.dto.CoinDto
import com.victorteka.data.network.dto.TeamMemberDto
import com.victorteka.domain.models.TeamMember
import com.victorteka.domain.models.Coin
import com.victorteka.domain.models.CoinDetails

internal fun CoinDto.toDomain(): Coin = Coin(
    id = id,
    isActive = isActive,
    name = name,
    rank = rank,
    symbol = symbol
)

internal fun CoinDetailsDto.toDomain(): CoinDetails = CoinDetails(
    coinId = id,
    name = name,
    description = description,
    symbol = symbol,
    rank = rank,
    isActive = isActive,
    tags = tags.map { it.name },
    team = team.map { it.toDomain() }
)

internal fun TeamMemberDto.toDomain(): TeamMember = TeamMember(
    id = id,
    name = name,
    position = position
)