package com.practice.dashboardapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun Header(
    modifier: Modifier = Modifier,
    greetings: String,
    name: String
) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = greetings, fontSize = 16.sp, color = Color.Black)
        Text(text = name, fontSize = 24.sp, color = Color.Black)
    }

}