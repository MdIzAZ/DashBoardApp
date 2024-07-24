package com.practice.dashboardapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.practice.dashboardapp.R


@Composable
fun CardRowSection(
    modifier: Modifier,
    todayClick: String,
    location: String,
    socialMedia: String
) {
    Row(
        modifier = modifier
            .height(200.dp)
            .fillMaxSize()
            .padding(10.dp),
    ) {
        LazyRow {
            item {
                SmallCard(icon = R.drawable.click, data = todayClick, title = "Today's clicks")
            }
            item {
                Spacer(modifier = Modifier.width(10.dp))
            }
            item {
                SmallCard(icon = R.drawable.location, data = location, title = "Top Location")
            }
            item {
                Spacer(modifier = Modifier.width(10.dp))
            }
            item {
                SmallCard(icon = R.drawable.source, data = socialMedia, title = "Top Source")
            }
        }
    }
}

@Composable
fun SmallCard(
    modifier: Modifier = Modifier,
    icon: Int,
    data: String,
    title: String,
) {

    ElevatedCard(
        modifier = Modifier.size(160.dp),
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(color = Color.Magenta.copy(alpha = 0.5f)),
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier.size(300.dp))
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = data, fontSize = 16.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = title, fontSize = 20.sp, color = Color.Black)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun V() {
    SmallCard(
        icon = R.drawable.click,
        data = "100",
        title = "Steps"
    )
}