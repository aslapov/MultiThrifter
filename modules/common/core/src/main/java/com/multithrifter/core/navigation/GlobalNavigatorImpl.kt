package com.multithrifter.core.navigation

import androidx.fragment.app.Fragment
import java.lang.ref.WeakReference
import javax.inject.Inject

class GlobalNavigatorImpl @Inject constructor() : GlobalNavigator {

    private var navigationHandler: WeakReference<NavigationHandler?> = WeakReference(null)

    override fun setNavigationHandler(navigationHandler: NavigationHandler) {
        this.navigationHandler = WeakReference(navigationHandler)
    }

    override fun resetNavigationHandler() {
        this.navigationHandler = WeakReference(null)
    }

    override fun back() {
        navigationHandler.get()?.onBack()
    }

    override fun exit() {
        navigationHandler.get()?.onExit()
    }

    override fun newRootFragment(root: Fragment, customAnimations: TransitionAnimationSet?) {
        navigationHandler.get()?.newRootFragment(root, customAnimations)
    }

    override fun openFragment(
        fragment: Fragment,
        addToBackStack: Boolean,
        customAnimations: TransitionAnimationSet?,
    ) {
        navigationHandler.get()?.openFragment(fragment, addToBackStack, customAnimations)
    }

    override fun openFullScreenFragment(
        fragment: Fragment,
        addToBackStack: Boolean,
        customAnimations: TransitionAnimationSet?
    ) {
        navigationHandler.get()?.openFullScreenFragment(fragment, addToBackStack, customAnimations)
    }
}