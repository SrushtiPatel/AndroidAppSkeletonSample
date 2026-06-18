package com.srushti.androidsampleproject.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.srushti.androidsampleproject.data.SportsItem
import com.srushti.androidsampleproject.navigation.Routes

@Composable
fun SportsItemCard(navController: NavController, sportsItem: SportsItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable(
                enabled = true,
                onClick = { navController.navigate(Routes.SportsDetail.name) }),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Text(text = sportsItem.sportName)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = sportsItem.sportDescription)
    }
}
