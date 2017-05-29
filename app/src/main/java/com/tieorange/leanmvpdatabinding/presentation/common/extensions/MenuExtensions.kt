/*
 * Copyright © 2017 inFullMobile. All rights reserved.
 */

package com.infullmobile.neuca.presentation.common.extensions

import android.view.Menu

/**
 * Created by jacek on 03/02/17.
 */
class MenuExtensions

val Menu.isEmpty: Boolean
    get() = !isNotEmpty

val Menu.isNotEmpty: Boolean
    get() = size() > 0

val Menu.lastItemIndex: Int
    get() = size() - 1
