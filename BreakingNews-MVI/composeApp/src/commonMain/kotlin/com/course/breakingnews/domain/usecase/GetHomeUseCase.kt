package com.course.breakingnews.domain.usecase

import com.course.breakingnews.domain.model.raw.NewsRawDomain
import com.course.breakingnews.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow

class GetHomeUseCase(private val repository: HomeRepository) {
    fun getBreakingNews() : Flow<NewsRawDomain> = repository.getBreakingNews()
}