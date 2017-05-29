/*
 * Copyright © 2016 inFullMobile. All rights reserved.
 */

package com.tieorange.leanmvpdatabinding.presentation.application.di;

import android.app.Application;
import android.support.annotation.NonNull;


public final class Components {

    private Components() {
        throw new AssertionError("No instances.");
    }

    public static <T> T from(@NonNull HasComponent<T> withComponent) {
        return withComponent.getComponent();
    }

    @SuppressWarnings("unchecked")
    //We are unable to reach application in its derived type
    public static ApplicationComponent from(@NonNull Application application) {
        return ((CarGoApplication) application).getComponent();
    }
}