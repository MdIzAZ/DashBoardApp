package com.practice.dashboardapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.practice.dashboardapp.presentation.components.CustomBottomBar
import com.practice.dashboardapp.presentation.components.TopAppBar
import com.practice.dashboardapp.presentation.screen.DashBoardViewModel
import com.practice.dashboardapp.presentation.screen.HomeScreen
import com.practice.dashboardapp.ui.theme.DashBoardAppTheme
import com.practice.dashboardapp.ui.theme.customBlue
import com.practice.dashboardapp.ui.theme.customGray
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val dashboardViewModel = hiltViewModel<DashBoardViewModel>()
            val responseState by dashboardViewModel.response.collectAsState()
            val snackBarHostState = remember { SnackbarHostState() }
            DashBoardAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopAppBar() },
                    bottomBar = { CustomBottomBar() },
                    snackbarHost = { SnackbarHost(hostState = snackBarHostState) }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(customBlue)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp))
                                .background(Color.White)
                        ) {
                            HomeScreen(
                                modifier = Modifier
                                    .background(customGray)
                                    .padding(top = 30.dp, start = 20.dp, end = 20.dp),
                                dashboardResponse = responseState,
                                snackBarHostState = snackBarHostState,
                                context = this@MainActivity
                            )
                        }
                    }
                }
            }
        }
    }
}

