package com.tieorange.leanmvpdatabinding.presentation.orders

import com.tieorange.leanmvpdatabinding.domain.model.orders.OrdersResult
import com.tieorange.leanmvpdatabinding.domain.usecases.order.AppLoadsAllOrders
import io.reactivex.Single

open class OrdersModel(private val appLoadsAllOrders: AppLoadsAllOrders) {

    open fun loadAllOrders(): Single<OrdersResult> {
        return appLoadsAllOrders.perform()
    }

}
