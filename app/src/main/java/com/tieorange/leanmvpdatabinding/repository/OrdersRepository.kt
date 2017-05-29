package com.tieorange.leanmvpdatabinding.repository

import com.tieorange.leanmvpdatabinding.domain.model.orders.OrderObject
import com.tieorange.leanmvpdatabinding.repository.cargo.CarGoService
import io.reactivex.Single

class OrdersRepository(carGoService: CarGoService) {
    fun getAllOrders(): Single<List<OrderObject>> {
        val list = mutableListOf<OrderObject>()
        list.add(OrderObject("Wrobel", 1))
        return Single.just(list)
    }

}