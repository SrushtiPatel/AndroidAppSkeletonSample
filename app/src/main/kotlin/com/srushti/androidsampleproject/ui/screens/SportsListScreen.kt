package com.srushti.androidsampleproject.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.srushti.androidsampleproject.data.SportsItem
import com.srushti.androidsampleproject.ui.SportsListViewModel

@Composable
fun SportsListScreen(sportsListViewModel: SportsListViewModel = hiltViewModel()) {

    sportsListViewModel.getSportsList()
    val sportsList by sportsListViewModel.sportsList.collectAsStateWithLifecycle()

// UI for displaying the sports list
    SportsList(sportsList)
}

@Composable
fun SportsList(sportsList: List<SportsItem>) {
    Scaffold(
        topBar = { SportsListTopBar() },
        modifier = Modifier.fillMaxWidth(),
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(Icons.Default.Search, contentDescription = "Search")
            }
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(sportsList) { sportsItem ->
                SportsItemCard(sportsItem)
            }
        }
    }

}

@Composable
fun SportsListTopBar() {

}