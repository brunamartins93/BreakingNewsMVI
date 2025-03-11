package com.course.breakingnews.features.home.state

import com.course.breakingnews.domain.model.news.NewsDomain

sealed interface HomeState {
    data object Idle: HomeState
    data object Loading: HomeState
    data class NavigateToDetails(
        val urlToImage: String,
        val description: String
    ): HomeState
    data class ShowData(val data: List<NewsDomain>) : HomeState
}