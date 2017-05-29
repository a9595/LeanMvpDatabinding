package com.tieorange.leanmvpdatabinding.repository

import com.tieorange.leanmvpdatabinding.OrderObject
import com.tieorange.leanmvpdatabinding.repository.cargo.CarGoService
import io.reactivex.Single

class OrdersRepository(carGoService: CarGoService) {
    fun getAllOrders(): Single<List<OrderObject>> {
        return Single.just(listOf<OrderObject>())
    }

}