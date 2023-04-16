package com.multithrifter.core.extensions

import android.view.View

fun View.applyFullScreen() {
    systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
}