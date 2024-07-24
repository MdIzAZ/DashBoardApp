package com.practice.dashboardapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.practice.dashboardapp.R
import com.practice.dashboardapp.domain.model.LinksData
import com.practice.dashboardapp.ui.theme.customBlueLight
import kotlinx.coroutines.launch

@Composable
fun LinksSection(
    modifier: Modifier = Modifier,
    links: List<LinksData>,
    snackBarHostState: SnackbarHostState,
) {
    links.forEach {
        LinksCard(linksData = it, snackBarHostState = snackBarHostState)
        Spacer(modifier = Modifier.height(16.dp))
    }
}


@Composable
fun LinksCard(
    linksData: LinksData,
    snackBarHostState: SnackbarHostState,
) {
    val clipboardManager = LocalClipboardManager.current
    var textToCopy by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()


    ElevatedCard(
        modifier = Modifier.height(150.dp)
    ) {
        Column(modifier = Modifier.background(color = Color.White)) {
            Column(
                modifier = Modifier
                    .height(100.dp)
                    .background(color = Color.White)
                    .padding(16.dp)
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    AsyncImage(
                        model = linksData.photos,
                        contentDescription = null,
                        modifier = Modifier.size(75.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(modifier = Modifier.width(200.dp)) {
                        Text(
                            text = linksData.title,
                            color = Color.Black,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = linksData.createdAt.substring(0, 10),
                            color = Color.Gray,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = linksData.clicks,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text(text = "Clicks", color = Color.Gray)
                    }
                }

            }
            HorizontalDivider(color = Color.Gray, thickness = 0.5.dp)
            Row(
                modifier = Modifier
                    .height(49.5.dp)
                    .fillMaxWidth()
                    .background(color = customBlueLight)
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = linksData.link.substring(0, 25), color = Color.Blue)
                Icon(
                    modifier = Modifier.clickable {
                        textToCopy = linksData.link
                        clipboardManager.setText(AnnotatedString(textToCopy))
                        scope.launch {
                            snackBarHostState.showSnackbar("Link copied to clipboard")
                        }
                    },
                    painter = painterResource(id = R.drawable.copy),
                    contentDescription = "copy",
                    tint = Color.Blue
                )
            }

        }

    }

}