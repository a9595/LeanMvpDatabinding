package com.tieorange.leanmvpdatabinding.presentation.application.di

import android.app.Application

/**
 * Created by andrii.kovalchuk on 29/05/2017.
 */

open class CarGoApplication : Application(), HasComponent<ApplicationComponent> {

    lateinit internal var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = buildComponent()
    }

    open protected fun buildComponent(): ApplicationComponent {
        return ApplicationGraph(this).component
    }

    override fun getComponent(): ApplicationComponent {
        return applicationComponent
    }
}
