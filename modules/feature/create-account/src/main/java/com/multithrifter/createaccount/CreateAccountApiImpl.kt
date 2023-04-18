package com.multithrifter.createaccount

import com.multithrifter.createaccount.presentation.navigation.Router
import javax.inject.Inject

internal class CreateAccountApiImpl @Inject constructor(
    private val router: Router,
) : CreateAccountApi {

    override fun showCreateAccountScreen() {
        router.showCreateAccountScreen()
    }
}