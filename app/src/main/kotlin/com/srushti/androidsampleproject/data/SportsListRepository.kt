package com.srushti.androidsampleproject.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SportsListRepository @Inject constructor() {
    fun getSportsList(): Flow<List<SportsItem>> = flow {
        val sports = listOf(
            SportsItem("Football", "World Cup"),
            SportsItem("Cricket", "ODI"),
            SportsItem("Hockey", "International"),
            SportsItem("Basketball", "NBA"),
            SportsItem("Baseball", "MLB")
        )
        emit(sports)
    }.flowOn(Dispatchers.IO)

}