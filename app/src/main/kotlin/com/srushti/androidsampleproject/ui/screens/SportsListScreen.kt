package com.srushti.androidsampleproject.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.srushti.androidsampleproject.data.SportsItem
import com.srushti.androidsampleproject.ui.SportsListViewModel

@Composable
fun SportsListScreen(navController: NavController) {
    val sportsListViewModel: SportsListViewModel = hiltViewModel()
    sportsListViewModel.getSportsList()
    val sportsList by sportsListViewModel.sportsList.collectAsStateWithLifecycle()

// UI for displaying the sports list
    SportsList(navController, sportsList)
}

@Composable
fun SportsList(navController: NavController, sportsList: List<SportsItem>) {
    Scaffold(
        topBar = { SportsListTopBar(navController) },
        modifier = Modifier.fillMaxWidth(),
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(Icons.Default.Search, contentDescription = "Search")
            }
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(sportsList) { sportsItem ->
                SportsItemCard(navController, sportsItem)
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SportsListTopBar(navController: NavController) {

    TopAppBar(
        title = {
            Text(text = "Sports")
        },
        modifier = Modifier.fillMaxWidth(),
        navigationIcon = {
            Icon(
                Icons.Filled.ArrowBack, contentDescription = "Back",
                modifier = Modifier
                    .padding(8.dp)
                    .clickable(onClick = {
                        navController.navigateUp()
                    })
            )
        }
    )
}