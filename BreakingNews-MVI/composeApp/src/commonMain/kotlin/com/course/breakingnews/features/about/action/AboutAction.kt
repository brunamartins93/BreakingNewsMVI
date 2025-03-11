package com.course.breakingnews.features.about.action

sealed interface AboutAction {
    data object Idle: AboutAction
    data object RequestOnBackPressed: AboutAction
    data object RequestAboutInfo: AboutAction
}