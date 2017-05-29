/*
 * Copyright © 2016 inFullMobile. All rights reserved.
 */

package com.tieorange.leanmvpdatabinding.presentation.application.di;


import com.tieorange.leanmvpdatabinding.domain.usecases.order.AppLoadsAllOrders;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        RepositoryModule.class,
        UseCaseModule.class,
        ServiceModule.class
})
public interface ApplicationComponent {
    AppLoadsAllOrders providesGetAllOrders();
}


