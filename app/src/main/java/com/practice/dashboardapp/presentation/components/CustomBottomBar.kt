package com.practice.dashboardapp.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.practice.dashboardapp.R
import com.practice.dashboardapp.ui.theme.customBlue

@Composable
fun CustomBottomBar() {

    var selectedItemNumber by remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxWidth()) {

        NavigationBar(
            containerColor = Color.White
        ) {
            navItems.forEachIndexed { index, navItem ->

                if (index == 2) {
                    Spacer(modifier = Modifier.width(7.dp))
                    FloatingActionButton(
                        containerColor = customBlue,
                        contentColor = Color.White,
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .clip(CircleShape)
                            .size(70.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "add")
                    }
                    Spacer(modifier = Modifier.width(7.dp))
                }

                NavigationBarItem(
                    selected = selectedItemNumber == index,
                    onClick = {
                        selectedItemNumber = index
                    },
                    icon = {
                        Icon(
                            painter = painterResource(
                                id = if (selectedItemNumber == index) navItem.selectedIcon
                                else navItem.unSelectedIcon
                            ),
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(text = navItem.title, color = Color.Black, maxLines = 1)
                    }
                )
            }

        }


    }


}


data class NavItem(
    val title: String,
    val selectedIcon: Int,
    val unSelectedIcon: Int,
)


val navItems = listOf(
    NavItem(
        title = "Links", selectedIcon = R.drawable.link, unSelectedIcon = R.drawable.link
    ),
    NavItem(
        title = "Course",
        selectedIcon = R.drawable.course,
        unSelectedIcon = R.drawable.course
    ),
    NavItem(
        title = "Campaigns",
        selectedIcon = R.drawable.campaign,
        unSelectedIcon = R.drawable.campaign
    ),
    NavItem(
        title = "Profile", selectedIcon = R.drawable.profile, unSelectedIcon = R.drawable.profile
    )

)


