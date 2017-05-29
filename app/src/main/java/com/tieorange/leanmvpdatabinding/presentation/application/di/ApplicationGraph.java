/*
 * Copyright © 2016 inFullMobile. All rights reserved.
 */

package com.tieorange.leanmvpdatabinding.presentation.application.di;


public class ApplicationGraph {
    private final DaggerApplicationComponent.Builder componentBuilder;

    public ApplicationGraph(CarGoApplication application) {
        componentBuilder = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(application))
                .repositoryModule(new RepositoryModule())
                .useCaseModule(new UseCaseModule());
    }

    public ApplicationComponent getComponent() {
        return componentBuilder.build();
    }
}
