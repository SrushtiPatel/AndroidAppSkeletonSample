package com.srushti.androidsampleproject.domain

import com.srushti.androidsampleproject.data.SportsItem
import com.srushti.androidsampleproject.data.SportsListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SportsListUsecase @Inject constructor(val sportsListRepository: SportsListRepository) {
    operator fun invoke(): Flow<List<SportsItem>> {
        return sportsListRepository.getSportsList()
    }
}