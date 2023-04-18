package com.multithrifter.core.extensions

import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment

fun Fragment.composeView(content: @Composable () -> Unit): View {
    return ComposeView(requireContext()).apply {
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        setContent(content)
    }
}

inline fun <reified T : Any> Fragment.getRequiredArgument(key: String): T {
    return requireArguments().getRequiredValue(key)
}