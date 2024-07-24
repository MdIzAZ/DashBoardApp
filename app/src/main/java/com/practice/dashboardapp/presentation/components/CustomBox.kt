package com.practice.dashboardapp.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CustomBox(
    borderColor: Color,
    color: Color,
    icon: Int,
    content: String,
    onBoxClick: (String) -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(5.dp)
            .clip(RoundedCornerShape(6.dp))
            .height(65.dp)
            .border(3.dp, borderColor)
            .fillMaxWidth()
            .background(color)
            .clickable { onBoxClick(content) }

    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                modifier = Modifier.size(40.dp),
                painter = painterResource(id = icon),
                contentDescription = "null",
                tint = borderColor
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = content, color = Color.Black)
        }
    }

}