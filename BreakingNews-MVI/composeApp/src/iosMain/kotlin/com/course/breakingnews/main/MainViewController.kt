package com.course.breakingnews.main

import androidx.compose.ui.window.ComposeUIViewController
import com.course.breakingnews.di.main.initializeKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initializeKoin() }
) { App() }