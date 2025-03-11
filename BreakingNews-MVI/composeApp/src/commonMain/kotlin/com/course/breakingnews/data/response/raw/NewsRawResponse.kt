package com.course.breakingnews.data.response.raw

import com.course.breakingnews.data.response.news.NewsResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsRawResponse(
    @SerialName("articles")
    val newsResponses: List<NewsResponse>? = null,
    @SerialName("status")
    val status: String? = null,
    @SerialName("totalResults")
    val totalResults: Int? = null
)