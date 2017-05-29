/*
 * Copyright © 2016 inFullMobile. All rights reserved.
 */

package com.tieorange.leanmvpdatabinding.presentation.application.di;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    public static final String SHARED_PREFERENCES_FILE = "prefs";
    private CarGoApplication app;

    public ApplicationModule(CarGoApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.app;
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences() {
        return app.getSharedPreferences(SHARED_PREFERENCES_FILE, Context.MODE_PRIVATE);
    }

    /*@Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }*/
}