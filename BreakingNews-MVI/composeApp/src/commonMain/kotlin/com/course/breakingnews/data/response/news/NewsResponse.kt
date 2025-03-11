package com.course.breakingnews.data.response.news


import com.course.breakingnews.data.response.source.SourceResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponse(
    @SerialName("author")
    val author: String? = null,
    @SerialName("content")
    val content: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("publishedAt")
    val publishedAt: String? = null,
    @SerialName("source")
    val sourceResponse: SourceResponse? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("url")
    val url: String? = null,
    @SerialName("urlToImage")
    val urlToImage: String? = null
)