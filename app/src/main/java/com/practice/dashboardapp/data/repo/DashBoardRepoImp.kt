package com.practice.dashboardapp.data.repo

import com.practice.dashboardapp.data.mapper.toDashBoardScreenData
import com.practice.dashboardapp.data.remote.AssignmentApi
import com.practice.dashboardapp.data.remote.dto.DashboardResponse
import com.practice.dashboardapp.domain.model.DashBoardScreenData
import com.practice.dashboardapp.domain.repo.DashBoardRepo
import kotlinx.coroutines.flow.Flow

class DashBoardRepoImp(
    private val api: AssignmentApi,
) : DashBoardRepo {
    override  suspend fun getAllDashboardData(): DashBoardScreenData {
        return  api.getDashboardData().toDashBoardScreenData()
    }
}