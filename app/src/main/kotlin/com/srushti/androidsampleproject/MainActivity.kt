package com.srushti.androidsampleproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.srushti.androidsampleproject.navigation.Routes
import com.srushti.androidsampleproject.ui.SportsListViewModel
import com.srushti.androidsampleproject.ui.screens.SportsDetailScreen
import com.srushti.androidsampleproject.ui.screens.SportsListScreen
import com.srushti.androidsampleproject.ui.screens.WelcomeScreen
import com.srushti.androidsampleproject.ui.theme.AndroidSampleProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val sportsListViewModel: SportsListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidSampleProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun NavHost(modifier: Modifier = Modifier) {
//    SportsListScreen(sportsListViewModel)
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Welcome.name) {
        composable(Routes.Welcome.name) {
            WelcomeScreen(navController)
        }
        composable(Routes.SportsList.name) {
            SportsListScreen(navController)
        }
        composable(Routes.SportsDetail.name) {
            SportsDetailScreen(navController)
        }
    }

}