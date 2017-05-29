/*
 * Copyright © 2017 inFullMobile. All rights reserved.
 */

package com.infullmobile.neuca.presentation.common.extensions

import android.support.design.widget.TabLayout

/**
 * Created by jacek on 01/03/17.
 */
class TabLayoutExtension

fun TabLayout.addOnTabSelectedListener(onTabSelectedAction: (tab: TabLayout.Tab) -> Unit)
        : TabLayout.OnTabSelectedListener {

    val listener = object : TabLayout.OnTabSelectedListener {
        override fun onTabReselected(tab: TabLayout.Tab) {
            /*empty*/
        }

        override fun onTabUnselected(tab: TabLayout.Tab) {
            /*empty*/
        }

        override fun onTabSelected(tab: TabLayout.Tab) {
            onTabSelectedAction(tab)
        }
    }
    addOnTabSelectedListener(listener)
    return listener
}