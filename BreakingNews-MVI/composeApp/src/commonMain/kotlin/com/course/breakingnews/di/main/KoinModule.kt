package com.course.breakingnews.di.main

import com.course.breakingnews.di.data.dataModule
import com.course.breakingnews.di.network.networkModule
import com.course.breakingnews.di.presentation.presentationModule
import com.course.breakingnews.di.usecase.useCaseRemoteModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun initializeKoin(
    config: (KoinApplication.() -> Unit)? = null
) {
    startKoin {
        config?.invoke(this)
        modules(
            presentationModule,
            dataModule,
            networkModule,
            useCaseRemoteModule
        )
    }
}