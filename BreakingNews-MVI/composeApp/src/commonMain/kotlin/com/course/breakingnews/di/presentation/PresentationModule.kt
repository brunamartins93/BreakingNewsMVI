package com.course.breakingnews.di.presentation

import com.course.breakingnews.features.about.viewmodel.AboutViewModel
import com.course.breakingnews.features.details.viewmodel.DetailsViewModel
import com.course.breakingnews.features.home.viewmodel.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::DetailsViewModel)
    viewModelOf(::AboutViewModel)
}