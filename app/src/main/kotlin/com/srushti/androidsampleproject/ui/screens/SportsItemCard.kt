package com.srushti.androidsampleproject.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.srushti.androidsampleproject.data.SportsItem

@Composable
fun SportsItemCard(sportsItem: SportsItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(
                shape = RoundedCornerShape(8.dp),
                color = Color.LightGray
            )
    ) {
        Text(text = sportsItem.sportName)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = sportsItem.sportDescription)
    }
}

@Preview(showBackground = true)
@Composable
private fun SportsItemPrev() {
    SportsItemCard(SportsItem("Football", "World Cup"))
}