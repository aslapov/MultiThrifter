package com.multithrifter.core.navigation

import androidx.fragment.app.Fragment

interface NavigationHandler {

    fun onBack()
    fun onExit()

    fun newRootFragment(
        root: Fragment,
        customAnimations: TransitionAnimationSet? = null
    )

    fun openFullScreenFragment(
        fragment: Fragment,
        addToBackStack: Boolean,
        customAnimations: TransitionAnimationSet? = null,
    )

    fun openFragment(
        fragment: Fragment,
        addToBackStack: Boolean,
        customAnimations: TransitionAnimationSet? = null,
    )
}