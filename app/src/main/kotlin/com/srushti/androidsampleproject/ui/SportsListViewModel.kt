package com.srushti.androidsampleproject.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.srushti.androidsampleproject.data.SportsItem
import com.srushti.androidsampleproject.domain.SportsListUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class SportsListViewModel @Inject constructor(val sportsListUsecase: SportsListUsecase) :
    ViewModel() {

    init {
        getSportsList()
    }

    private val _sportsList = MutableStateFlow<List<SportsItem>>(emptyList())
    val sportsList: StateFlow<List<SportsItem>> = _sportsList

    fun getSportsList() {
        //TODO create UiState
        sportsListUsecase().onStart {

        }.onEach { sports ->
            _sportsList.value = sports
        }.launchIn(viewModelScope)
    }
}
