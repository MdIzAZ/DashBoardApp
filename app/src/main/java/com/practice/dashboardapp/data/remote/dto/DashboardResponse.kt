package com.practice.dashboardapp.data.remote.dto

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Serializable
@Keep
data class DashboardResponse(
    val applied_campaign: Int,
    val `data`: Data,
    val extra_income: Double,
    val links_created_today: Int,
    val startTime: String,
    val support_whatsapp_number: String,
    val today_clicks: Int,
    val top_location: String,
    val top_source: String,
    val total_clicks: Int,
    val total_links: Int
)

@Serializable
@Keep
data class Data(
    val overall_url_chart: Map<String, Int>,
    val recent_links: List<RecentLink>,
    val top_links: List<TopLink>
)

@Serializable
@Keep
data class RecentLink(
    val app: String,
    val created_at: String,
    val domain_id: String,
    val is_favourite: Boolean,
    val original_image: String,
    val smart_link: String,
    val thumbnail: String?,
    val times_ago: String,
    val title: String,
    val total_clicks: Int,
    val url_id: Int,
    val url_prefix: String?,
    val url_suffix: String,
    val web_link: String
)

@Serializable
@Keep
data class TopLink(
    val app: String,
    val created_at: String,
    val domain_id: String,
    val is_favourite: Boolean,
    val original_image: String,
    val smart_link: String,
    val thumbnail: String?,
    val times_ago: String,
    val title: String,
    val total_clicks: Int,
    val url_id: Int,
    val url_prefix: String,
    val url_suffix: String,
    val web_link: String
)