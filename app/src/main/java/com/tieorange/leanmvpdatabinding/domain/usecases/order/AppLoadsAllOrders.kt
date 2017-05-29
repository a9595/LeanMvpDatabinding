package com.tieorange.leanmvpdatabinding.domain.usecases.order

import com.infullmobile.neuca.domain.usecases.UseCase
import com.tieorange.leanmvpdatabinding.OrderObject
import com.tieorange.leanmvpdatabinding.domain.model.orders.OrdersResult
import com.tieorange.leanmvpdatabinding.domain.usecases.UseCaseSchedule
import com.tieorange.leanmvpdatabinding.repository.OrdersRepository
import io.reactivex.Single

/**
 * Created by andrii.kovalchuk on 29/05/2017.
 */

class AppLoadsAllOrders(useCaseSchedule: UseCaseSchedule,
                        private val ordersRepository: OrdersRepository)
    : UseCase<OrdersResult>(useCaseSchedule) {

    override fun doWork(): Single<OrdersResult> {
        return ordersRepository.getAllOrders()
                .subscribeOn(useCaseSchedule.scheduler)
                .map { orders -> makeOrdersResult(orders) }
    }

    private fun makeOrdersResult(orders: List<OrderObject>): OrdersResult {
        return OrdersResult(orders)
    }
}

