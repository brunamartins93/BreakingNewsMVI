package com.course.breakingnews.domain.model.news

import com.course.breakingnews.domain.model.source.SourceDomain

data class NewsDomain(
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
    val sourceDomain: SourceDomain? = null,
    val title: String? = null,
    val url: String? = null,
    val urlToImage: String? = null
)