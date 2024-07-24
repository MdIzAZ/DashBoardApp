package com.practice.dashboardapp.data.remote

import com.practice.dashboardapp.data.remote.dto.DashboardResponse
import retrofit2.http.GET

interface AssignmentApi {

    @GET("dashboardNew")
    suspend fun getDashboardData(): DashboardResponse
}