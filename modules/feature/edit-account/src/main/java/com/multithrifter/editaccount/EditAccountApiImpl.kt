package com.multithrifter.editaccount

import com.multithrifter.core.domain.entity.Account
import com.multithrifter.editaccount.presentation.navigation.Router
import javax.inject.Inject

internal class EditAccountApiImpl @Inject constructor(
    private val router: Router,
) : EditAccountApi {

    override fun showEditAccountScreen(account: Account) {
        router.showEditAccountScreen(account)
    }
}