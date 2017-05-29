/*
 * Copyright © 2017 inFullMobile. All rights reserved.
 */

package com.infullmobile.neuca.presentation.common.extensions

import android.os.Build
import android.support.v7.app.AppCompatActivity
import com.infullmobile.android.infullmvp.Lazy
import com.infullmobile.android.infullmvp.PresentedView
import com.infullmobile.android.infullmvp.Presenter
import com.infullmobile.android.infullmvp.requiredInt
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Created by jacek on 12/01/17.
 */

class PresenterExtensions

val PresentedView<*, *>.integerFinder: PresentedView<*, *>.(Int) -> Int?
    get() = { context.resources.getInteger(it) }

val PresentedView<*, *>.fragmentFinder: PresentedView<*, *>.(Int) -> android.support.v4.app.Fragment?
    get() = { (context as AppCompatActivity).supportFragmentManager?.findFragmentById(it) }

fun <F : android.support.v4.app.Fragment> PresentedView<*, *>.bindFragment(id: Int)
        : ReadOnlyProperty<PresentedView<*, *>, F> {
    return requiredFragment(id, fragmentFinder)
}

@Suppress("UNCHECKED_CAST")
fun <T, V : android.support.v4.app.Fragment>
        requiredFragment(id: Int, finder: T.(Int) -> android.support.v4.app.Fragment?)
        = Lazy { t: T, desc -> t.finder(id) as V? ?: fragmentNotFound(id, desc) }

fun fragmentNotFound(id: Int, desc: KProperty<*>): Nothing =
        throw IllegalStateException("View ID $id for '${desc.name}' not found.")

fun Presenter<*>.deviceRunsKitkatThroughLolipopMR1(): Boolean {
    return deviceRunsApis(Build.VERSION_CODES.KITKAT, Build.VERSION_CODES.LOLLIPOP_MR1)
}

fun Presenter<*>.deviceRunsApis(minApiLevel: Int, maxApiLevel: Int): Boolean {
    val currentApiVersion = Build.VERSION.SDK_INT
    return currentApiVersion >= minApiLevel && currentApiVersion <= maxApiLevel
}
