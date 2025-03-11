package com.course.breakingnews.di.data

import com.course.breakingnews.data.repository.HomeRepositoryImpl
import com.course.breakingnews.domain.repository.HomeRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    // Home
    factoryOf(::HomeRepositoryImpl).bind(HomeRepository::class)
}