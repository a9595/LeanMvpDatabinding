/*
 * Copyright © 2016 inFullMobile. All rights reserved.
 */

package com.tieorange.leanmvpdatabinding.presentation.application.di

import android.app.Application


class Components private constructor() {

    init {
        throw AssertionError("No instances.")
    }

    companion object {

        fun <T> from(withComponent: HasComponent<T>): T {
            return withComponent.component
        }

        //We are unable to reach application in its derived type
        fun from(application: Application): ApplicationComponent {
            return (application as CarGoApplication).component
        }
    }
}