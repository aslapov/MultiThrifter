package com.multithrifter.core.navigation

import androidx.fragment.app.Fragment

interface GlobalNavigator {

    fun setNavigationHandler(navigationHandler: NavigationHandler)
    fun resetNavigationHandler()
    fun back()
    fun exit()

    /**
     * Открывает новый корневой фрагмент взамен всех других
     */
    fun newRootFragment(
        root: Fragment,
        customAnimations: TransitionAnimationSet? = null
    )

    /**
     * @param customAnimations - набор из анимаций, с которым будет происходить транзакция фрагмента
     */
    fun openFragment(
        fragment: Fragment,
        addToBackStack: Boolean,
        customAnimations: TransitionAnimationSet? = null,
    )

    fun openFullScreenFragment(
        fragment: Fragment,
        addToBackStack: Boolean,
        customAnimations: TransitionAnimationSet? = null,
    )
}