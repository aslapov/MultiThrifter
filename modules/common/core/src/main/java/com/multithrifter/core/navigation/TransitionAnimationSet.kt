package com.multithrifter.core.navigation

import androidx.annotation.AnimRes
import androidx.annotation.AnimatorRes

data class TransitionAnimationSet(
    @AnimatorRes @AnimRes val enter: Int = 0,
    @AnimatorRes @AnimRes val exit: Int = 0,
    @AnimatorRes @AnimRes val popEnter: Int = 0,
    @AnimatorRes @AnimRes val popExit: Int = 0,
)
