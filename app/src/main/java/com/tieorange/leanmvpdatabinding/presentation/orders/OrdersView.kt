package com.tieorange.leanmvpdatabinding.presentation.orders

import android.support.annotation.LayoutRes
import com.tieorange.leanmvpdatabinding.R
import com.tieorange.leanmvpdatabinding.mvp.PresentedActivityView

open class OrdersView()
    : PresentedActivityView<OrdersPresenter>() {

    @LayoutRes override val layoutResId = R.layout.activity_orders

    override fun onViewsBound() {

    }
}
