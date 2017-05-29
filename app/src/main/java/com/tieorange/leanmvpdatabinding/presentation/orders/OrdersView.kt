package com.tieorange.leanmvpdatabinding.presentation.orders

import android.support.annotation.LayoutRes
import com.tieorange.leanmvpdatabinding.R
import com.tieorange.leanmvpdatabinding.databinding.ActivityOrdersBinding
import com.tieorange.leanmvpdatabinding.presentation.common.mvpdatabinding.PresentedActivityView

open class OrdersView()
    : PresentedActivityView<OrdersPresenter>() {

    @LayoutRes override val layoutResId = R.layout.activity_orders
    lateinit var binding: ActivityOrdersBinding

    override fun onViewsBound() {

    }

}