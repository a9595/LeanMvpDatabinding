package com.tieorange.leanmvpdatabinding.presentation.orders.di;

import android.support.annotation.VisibleForTesting;

import com.tieorange.leanmvpdatabinding.presentation.application.di.ApplicationComponent;
import com.tieorange.leanmvpdatabinding.presentation.application.di.Components;
import com.tieorange.leanmvpdatabinding.presentation.orders.OrdersActivity;

import dagger.Component;

public class OrdersGraph {

    private final DaggerOrdersGraph_OrdersComponent.Builder builder;

    public OrdersGraph(OrdersActivity activity) {
        this.builder = DaggerOrdersGraph_OrdersComponent
                .builder()
                .applicationComponent(Components.Companion.from(activity.getApplication()))
                .ordersModule(new OrdersModule(activity));
    }

    public void inject(OrdersActivity activity) {
        builder.build().inject(activity);
    }

    @VisibleForTesting
    public void setOrdersModule(OrdersModule module) {
        builder.ordersModule(module);
    }

    @OrdersScope
    @Component(
            dependencies = ApplicationComponent.class,
            modules = OrdersModule.class
    )
    public interface OrdersComponent {
        void inject(OrdersActivity activity);
    }
}
