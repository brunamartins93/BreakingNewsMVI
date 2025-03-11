package com.course.breakingnews.features.details.state

sealed interface DetailsState {
    data object Idle: DetailsState
    data object Loading: DetailsState
    data object OnBackPressed: DetailsState
    data class RequestUpdateView(
        val urlToImage: String,
        val description: String
    ): DetailsState
}