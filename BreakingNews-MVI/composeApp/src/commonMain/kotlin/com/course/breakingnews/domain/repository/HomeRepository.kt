package com.course.breakingnews.domain.repository

import com.course.breakingnews.domain.model.raw.NewsRawDomain
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getBreakingNews() : Flow<NewsRawDomain>
}