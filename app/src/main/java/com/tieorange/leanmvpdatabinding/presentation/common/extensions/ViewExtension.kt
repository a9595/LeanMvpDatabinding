/*
 * Copyright © 2017 inFullMobile. All rights reserved.
 */

package com.infullmobile.neuca.presentation.common.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView

/**
 * Created by jacek on 05/01/17.
 */
class ViewExtension

var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        if (value) showIfInvisible() else hideIfVisible()
    }

val View.isGone: Boolean
    get() = visibility == View.GONE

val View.isInvisible: Boolean
    get() = visibility != View.VISIBLE

fun View.showIfInvisible(): Int {
    if (isInvisible) {
        visibility = View.VISIBLE
    }
    return visibility
}

fun View.visible(): Int {
    visibility = View.VISIBLE
    return visibility
}

fun View.gone(): Int {
    visibility = View.GONE
    return visibility
}

fun View.hideIfVisible(): Int {
    if (isVisible) {
        visibility = View.INVISIBLE
    }
    return visibility
}

fun View.goneIfVisible(): Int {
    if (isVisible) {
        visibility = View.GONE
    }

    return visibility
}

fun TextView.isEllipsized(): Boolean {
    val lastLineToCheck = if (lineCount > 0) lineCount - 1 else 0
    if (lastLineToCheck > 0) {
        return (layout?.getEllipsisCount(lastLineToCheck) ?: 0) > 0
    }
    return false
}

fun View.onFocusChange(f: (View, Boolean) -> Unit) {
    this.setOnFocusChangeListener(f)
}

fun View.hideSoftKeyboard() {
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}

fun EditText.showSoftKeyboard() {
    if (this.requestFocus()) {
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }
}
