package com.practice.dashboardapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.practice.dashboardapp.ui.theme.customBlue
import com.practice.dashboardapp.ui.theme.customBlue2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    MediumTopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = customBlue
        ),
        title = { Text(text = "DashBoard") },
        actions = {
            ElevatedCard(
                modifier = Modifier
                    .padding(15.dp)
                    .size(50.dp),
                colors = CardDefaults.cardColors(containerColor = customBlue2)
            ) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Settings",
                    modifier = Modifier
                        .size(50.dp)
                        .padding(10.dp)
                        .clickable {}
                )
            }
        }
    )
}