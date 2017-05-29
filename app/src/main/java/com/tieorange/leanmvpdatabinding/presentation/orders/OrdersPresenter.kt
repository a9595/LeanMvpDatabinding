package com.tieorange.leanmvpdatabinding.presentation.orders

import android.net.Uri
import android.os.Bundle
import com.infullmobile.android.infullmvp.Presenter
import com.tieorange.leanmvpdatabinding.databinding.ActivityOrdersBinding

open class OrdersPresenter(private val model: OrdersModel,
                           view: OrdersView) : Presenter<OrdersView>(view) {

    lateinit var binding: ActivityOrdersBinding

    override fun bind(intentBundle: Bundle, savedInstanceState: Bundle, intentData: Uri?) {

    }

}
