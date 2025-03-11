package com.course.breakingnews.data.mapping

import com.course.breakingnews.data.response.raw.NewsRawResponse
import com.course.breakingnews.data.response.news.NewsResponse
import com.course.breakingnews.data.response.source.SourceResponse
import com.course.breakingnews.domain.model.news.NewsDomain
import com.course.breakingnews.domain.model.raw.NewsRawDomain
import com.course.breakingnews.domain.model.source.SourceDomain

fun NewsRawResponse.toDomain() = NewsRawDomain(
    status = this.status,
    totalResults = this.totalResults,
    newsDomains = this.newsResponses?.map { it.toDomain() }
)

fun NewsResponse.toDomain() = NewsDomain(
    author = this.author,
    content = this.content,
    description = this.description,
    publishedAt = this.publishedAt,
    sourceDomain = this.sourceResponse?.toDomain(),
    title = this.title,
    urlToImage = this.urlToImage
)

fun SourceResponse.toDomain() = SourceDomain(
    id = this.id,
    name = this.name
)