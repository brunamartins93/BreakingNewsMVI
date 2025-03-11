package com.course.breakingnews.features.details.action

sealed interface DetailsAction {
    data object Idle: DetailsAction
    data object RequestOnBackPressed: DetailsAction
    data object RequestUpdateView: DetailsAction
}