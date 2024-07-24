package com.practice.dashboardapp.data.mapper

import co.yml.charts.common.model.Point
import com.practice.dashboardapp.data.remote.dto.DashboardResponse
import com.practice.dashboardapp.data.remote.dto.RecentLink
import com.practice.dashboardapp.data.remote.dto.TopLink
import com.practice.dashboardapp.domain.model.DashBoardScreenData
import com.practice.dashboardapp.domain.model.LinksData


fun Map<String, Int>.toPoints(): List<Point> {
    return this.entries
        .sortedBy { it.key }
        .map {
            val hour = it.key.substring(0, 2).toIntOrNull() ?: 0
            Point(x = hour.toFloat(), y = it.value.toFloat())
        }
}

fun RecentLink.toLinksData() : LinksData{
    return LinksData(
        photos = this.original_image,
        clicks = this.total_clicks.toString(),
        createdAt = this.created_at,
        title = this.title,
        link = this.web_link
    )
}

fun TopLink.toLinksData() : LinksData{
    return LinksData(
        photos = this.original_image,
        clicks = this.total_clicks.toString(),
        createdAt = this.created_at,
        title = this.title,
        link = this.web_link
    )
}

fun DashboardResponse.toDashBoardScreenData() : DashBoardScreenData{
    return DashBoardScreenData(
        data = this.data,
        supportWhatsappNumber = this.support_whatsapp_number,
        todayClicks = this.today_clicks,
        topLocation = this.top_location,
        topSource = this.top_source,
        totalClicks = this.total_clicks
    )
}
