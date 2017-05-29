package com.infullmobile.neuca.presentation.common.extensions

import android.widget.ViewAnimator

/**
 * Copyright (c) 2016 inFullMobile. All rights reserved.
 * Created by pawelswietochowski on 04/01/2017.
 */

fun ViewAnimator.setDisplayedChildWithoutAnimation(childIndex: Int) {
    val inAnimation = this.inAnimation
    val outAnimation = this.outAnimation
    this.inAnimation = null
    this.outAnimation = null
    this.displayedChild = childIndex
    this.inAnimation = inAnimation
    this.outAnimation = outAnimation
}
