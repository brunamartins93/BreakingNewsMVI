package com.course.breakingnews.di.usecase

import com.course.breakingnews.domain.usecase.GetHomeUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseRemoteModule = module {
    // Home
    factoryOf(::GetHomeUseCase)
}