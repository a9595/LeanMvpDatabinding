package com.tieorange.leanmvpdatabinding.presentation.orders.di;

import android.content.Context;

import com.tieorange.leanmvpdatabinding.presentation.orders.OrdersActivity;
import com.tieorange.leanmvpdatabinding.presentation.orders.OrdersModel;
import com.tieorange.leanmvpdatabinding.presentation.orders.OrdersPresenter;
import com.tieorange.leanmvpdatabinding.presentation.orders.OrdersView;

import dagger.Module;
import dagger.Provides;

@Module
public class OrdersModule {

    private OrdersActivity activity;

    public OrdersModule(OrdersActivity activity) {
        this.activity = activity;
    }

    @OrdersScope
    @Provides
    Context providesContext() {
        return activity;
    }

    @OrdersScope
    @Provides
    OrdersView providesOrdersView() {
        return new OrdersView();
    }

    @OrdersScope
    @Provides
    public OrdersModel providesOrdersModel() {
        return new OrdersModel();
    }

    @OrdersScope
    @Provides
    OrdersPresenter providesOrdersPresenter(OrdersModel model,
            OrdersView view) {
        return new OrdersPresenter(model, view);
    }
}
