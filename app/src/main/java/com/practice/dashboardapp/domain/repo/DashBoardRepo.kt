package com.practice.dashboardapp.domain.repo

import com.practice.dashboardapp.data.remote.dto.DashboardResponse
import com.practice.dashboardapp.domain.model.DashBoardScreenData
import kotlinx.coroutines.flow.Flow

interface DashBoardRepo {
    suspend fun getAllDashboardData(): DashBoardScreenData
}