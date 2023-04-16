package com.multithrifter.core.extensions

import androidx.fragment.app.Fragment
import com.multithrifter.core.R
import com.multithrifter.core.navigation.GlobalNavigator
import com.multithrifter.core.navigation.TransitionAnimationSet

private val slideTransitionAnimation by lazy(LazyThreadSafetyMode.NONE) {
    TransitionAnimationSet(
        enter = R.anim.core_slide_in_right,
        exit = R.anim.core_slide_out_left,
        popEnter = R.anim.core_slide_in_left,
        popExit = R.anim.core_slide_out_right
    )
}

fun GlobalNavigator.openFragmentWithSlideAnimation(
    fragment: Fragment,
    addToBackStack: Boolean
) {
    openFragment(
        fragment = fragment,
        addToBackStack = addToBackStack,
        customAnimations = slideTransitionAnimation
    )
}

fun GlobalNavigator.openFullScreenFragmentWithSlideAnimation(
    fragment: Fragment,
    addToBackStack: Boolean
) {
    openFullScreenFragment(
        fragment = fragment,
        addToBackStack = addToBackStack,
        customAnimations = slideTransitionAnimation
    )
}

fun GlobalNavigator.openNewRootFragmentWithSlideAnimation(
    fragment: Fragment,
) {
    newRootFragment(
        root = fragment,
        customAnimations = slideTransitionAnimation
    )
}