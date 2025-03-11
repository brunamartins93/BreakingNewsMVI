package com.course.breakingnews.domain.model.raw

import com.course.breakingnews.domain.model.news.NewsDomain

data class NewsRawDomain(
    val newsDomains: List<NewsDomain>? = null,
    val status: String? = null,
    val totalResults: Int? = null
)