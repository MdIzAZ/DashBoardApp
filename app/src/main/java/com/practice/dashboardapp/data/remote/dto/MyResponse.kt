//package com.practice.assignmentapp.data.remote.dto
//
//import kotlinx.serialization.SerialName
//import kotlinx.serialization.Serializable
//
//@Serializable
//data class MyResponse(
//    @SerialName("applied_campaign")
//    val appliedCampaign: Int,
//    val `data`: Data,
//    @SerialName("extra_income")
//    val extraIncome: Double,
//    @SerialName("links_created_today")
//    val linksCreatedToday: Int,
//    val message: String,
//    val startTime: String,
//    val status: Boolean,
//    val statusCode: Int,
//    @SerialName("support_whatsapp_number")
//    val supportWhatsappNumber: String,
//    @SerialName("today_clicks")
//    val todayClicks: Int,
//    @SerialName("top_location")
//    val top_location: String,
//    @SerialName("top_source")
//    val topSource: String,
//    @SerialName("total_clicks")
//    val totalClicks: Int,
//    @SerialName("total_links")
//    val totalLinks: Int
//)
//
//
//@Serializable
//data class Data(
//    @SerialName("overall_url_chart")
//    val overallUrlChart: Map<String, Int>,
//    @SerialName("recent_links")
//    val recentLinks: List<RecentLink>,
//    @SerialName("top_links")
//    val topLinks: List<TopLink>
//)
//
//@Serializable
//data class TopLink(
//    val app: String,
//    @SerialName("created_at")
//    val createdAt: String,
////    val domain_id: String,
////    val is_favourite: Boolean,
//    @SerialName("original_image")
//    val originalImage: String,
//    @SerialName("smart_link")
//    val smartLink: String,
//    val thumbnail: String?,
////    val times_ago: String,
//    val title: String,
//    @SerialName("total_clicks")
//    val totalClicks: Int,
////    val url_id: Int,
////    val url_prefix: String?,
////    val url_suffix: String,
//    @SerialName("web_link")
//    val webLink: String
//)
//
//@Serializable
//data class RecentLink(
//    val app: String,
//    @SerialName("created_at")
//    val createdAt: String,
////    val domain_id: String,
////    val is_favourite: Boolean,
//    @SerialName("original_image")
//    val originalImage: String,
//    @SerialName("smart_link")
//    val smartLink: String,
//    val thumbnail: String?,
////    val times_ago: String,
//    val title: String,
//    @SerialName("total_clicks")
//    val totalClicks: Int,
////    val url_id: Int,
////    val url_prefix: String?,
////    val url_suffix: String,
//    @SerialName("web_link")
//    val webLink: String
//)