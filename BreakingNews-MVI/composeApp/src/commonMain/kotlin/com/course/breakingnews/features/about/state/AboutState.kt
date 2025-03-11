package com.course.breakingnews.features.about.state

sealed interface AboutState {
    data object Idle: AboutState
    data object Loading: AboutState
    data object OnBackPressed: AboutState
    data class ShowData(val data: List<Pair<String, String>>): AboutState
}