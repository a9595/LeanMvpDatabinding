package com.tieorange.leanmvpdatabinding.presentation.orders

import android.content.Context
import android.content.Intent
import android.databinding.ViewDataBinding
import android.os.Bundle
import com.tieorange.leanmvpdatabinding.databinding.ActivityOrdersBinding
import com.tieorange.leanmvpdatabinding.presentation.common.mvpdatabinding.InFullMvpActivity
import com.tieorange.leanmvpdatabinding.presentation.orders.di.OrdersGraph
import javax.inject.Inject

class OrdersActivity : InFullMvpActivity<OrdersPresenter, OrdersView, ViewDataBinding>() {

    @Inject lateinit var ordersPresenter: OrdersPresenter
    @Inject lateinit var ordersView: OrdersView
    lateinit var ordersGraph: OrdersGraph

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ordersGraph = OrdersGraph(this)
    }

    override val presenter: OrdersPresenter get() = ordersPresenter
    override val presentedView: OrdersView get() = ordersView

    override fun injectIntoGraph() {
        ordersGraph.inject(this)
    }

    override fun bindingFinished(binding: ViewDataBinding) {
        val activityOrdersBinding = binding as ActivityOrdersBinding
        presenter.binding = activityOrdersBinding
        presentedView.binding = activityOrdersBinding
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, OrdersActivity::class.java)
        }
    }
}
