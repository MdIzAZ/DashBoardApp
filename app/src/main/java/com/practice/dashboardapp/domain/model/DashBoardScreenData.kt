package com.practice.dashboardapp.domain.model

import com.practice.dashboardapp.data.remote.dto.Data

data class DashBoardScreenData(
    val `data`: Data,
    val supportWhatsappNumber: String,
    val todayClicks: Int,
    val topLocation: String,
    val topSource: String,
    val totalClicks: Int,
)
