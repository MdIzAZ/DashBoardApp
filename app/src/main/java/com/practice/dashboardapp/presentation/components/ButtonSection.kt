package com.practice.dashboardapp.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.practice.dashboardapp.ui.theme.customBlue

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier,
    onButtonClick: (Int) -> Unit,
    onSearchIconClick: () -> Unit,
) {

    val buttons = listOf<String>("Top Links", "Recent Links")
    var selectedButtonNumber by remember { mutableStateOf(-1) }

    Row {
        buttons.forEachIndexed { index, it ->
            Button(
                onClick = {
                    selectedButtonNumber = buttons.indexOf(it)
                    onButtonClick(index)
                },
                modifier = Modifier.height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    if (selectedButtonNumber == index) customBlue else Color.White
                )
            ) {
                Text(text = it)
            }
            Spacer(modifier = Modifier.size(8.dp))
        }

        Spacer(modifier = Modifier.size(62.dp))

        IconButton(
            onClick = { onSearchIconClick() },
            modifier = Modifier
                .clip(RoundedCornerShape(10))
                .background(Color.Gray)
        ) {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        }


    }
}