package com.practice.dashboardapp.presentation.screen

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.practice.dashboardapp.R
import com.practice.dashboardapp.data.mapper.toLinksData
import com.practice.dashboardapp.data.remote.dto.DashboardResponse
import com.practice.dashboardapp.domain.model.DashBoardScreenData
import com.practice.dashboardapp.domain.model.LinksData
import com.practice.dashboardapp.presentation.components.ButtonSection
import com.practice.dashboardapp.presentation.components.CardRowSection
import com.practice.dashboardapp.presentation.components.CustomBox
import com.practice.dashboardapp.presentation.components.Graph
import com.practice.dashboardapp.presentation.components.Header
import com.practice.dashboardapp.presentation.components.LinksSection
import com.practice.dashboardapp.ui.theme.customBlueLight
import com.practice.dashboardapp.ui.theme.customGreenLight
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    dashboardResponse: DashBoardScreenData?,
    snackBarHostState: SnackbarHostState,
    context: Context,
) {
    var links by remember { mutableStateOf(listOf<LinksData>()) }
    val scope = rememberCoroutineScope()

    LazyColumn(modifier = modifier.fillMaxSize()) {
        item {
            Header(
                greetings = "Good morning",
                name = "Sk Md Izaz"
            )
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item { Graph(dashboardResponse?.data?.overall_url_chart) }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            if (dashboardResponse != null) {
                CardRowSection(
                    modifier = Modifier.height(200.dp),
                    todayClick = dashboardResponse.todayClicks.toString(),
                    location = dashboardResponse.topLocation,
                    socialMedia = dashboardResponse.topSource,
                )
            }
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            OutlinedButton(modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(2.dp)), onClick = { }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.analytics),
                    contentDescription = "Settings",
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "View Analytics", color = Color.Black)
            }
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            ButtonSection(
                onButtonClick = {
                    if (dashboardResponse != null) {
                        val list = when (it) {
                            0 -> dashboardResponse.data.top_links.map {
                                it.toLinksData()
                            }

                            1 -> dashboardResponse.data.recent_links.map {
                                it.toLinksData()
                            }

                            else -> emptyList()
                        }
                        links = list
                    }
                },
                onSearchIconClick = {}
            )
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            LinksSection(links = links, snackBarHostState = snackBarHostState)
        }

        item {
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(2.dp)),
                onClick = {
                    if (dashboardResponse != null) {
                        links = dashboardResponse.data.top_links.map {
                            it.toLinksData()
                        } + dashboardResponse.data.recent_links.map {
                            it.toLinksData()
                        }
                    }
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.link),
                    contentDescription = "Link",
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "View all Links", color = Color.Black)
            }
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            CustomBox(
                borderColor = Color.Green,
                color = customGreenLight,
                icon = R.drawable.baseline_chat_bubble_outline_24,
                content = "Talk with us",
                onBoxClick = {
                    if (it == "Talk with us") {
                        chatInWhatsApp(dashboardResponse?.supportWhatsappNumber, context, scope)
                    }
                }
            )
        }

        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            CustomBox(
                borderColor = Color.Blue,
                color = customBlueLight,
                icon = R.drawable.faq,
                content = "Frequently Asked Questions",
                onBoxClick = {

                }
            )
        }

        item { Spacer(modifier = Modifier.height(40.dp)) }


    }

}


fun chatInWhatsApp(number: String?, context: Context, scope: CoroutineScope) {
    val uri = Uri.parse("https://wa.me/${number}")
    val intent = Intent(Intent.ACTION_VIEW, uri)
    intent.setPackage("com.whatsapp")

    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    } else {
        scope.launch {
            Toast.makeText(context, "WhatsApp not installed", Toast.LENGTH_LONG).show()
        }
    }
}

