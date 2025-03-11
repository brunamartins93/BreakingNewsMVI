package com.course.breakingnews.features.home.action

sealed interface HomeAction {
    data object Idle: HomeAction
    data class RequestNavigateToDetails(
        val urlToImage: String,
        val description: String
    ): HomeAction
    data object RequestBreakingNews: HomeAction
}